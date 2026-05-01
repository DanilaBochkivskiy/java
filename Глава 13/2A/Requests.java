import java.sql.*;

public class Requests {
    private Connection conn;

    public Requests(Connection conn) {
        this.conn = conn;
    }

    public void printRecentMovies() throws SQLException {
        String sql = "SELECT title, release_date FROM movies " +
                "WHERE YEAR(release_date) >= YEAR(CURDATE()) - 1";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("Фильмы (2025-2026):");
            while (rs.next()) {
                System.out.println("- " + rs.getString("title") + " [" + rs.getDate("release_date") + "]");
            }
        }
    }

    public void printActorsByMovie(String movieTitle) throws SQLException {
        String sql = "SELECT p.full_name, p.birth_date FROM persons p " +
                "JOIN movie_cast mc ON p.id = mc.actor_id " +
                "JOIN movies m ON mc.movie_id = m.id WHERE m.title = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, movieTitle);
            ResultSet rs = ps.executeQuery();
            System.out.println("Актеры фильма '" + movieTitle + "':");
            while (rs.next()) {
                System.out.println("- " + rs.getString("full_name") + " (д.р. " + rs.getDate("birth_date") + ")");
            }
        }
    }

    public void printActorsWithMinMovies(int n) throws SQLException {
        String sql = "SELECT p.full_name, COUNT(mc.movie_id) as movie_count FROM persons p " +
                "JOIN movie_cast mc ON p.id = mc.actor_id " +
                "GROUP BY p.id, p.full_name HAVING COUNT(mc.movie_id) >= ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, n);
            ResultSet rs = ps.executeQuery();
            System.out.println("Актеры, снявшиеся в " + n + " и более фильмах:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("full_name") + " (Фильмов: " + rs.getInt("movie_count") + ")");
            }
        }
    }

    public void printActorsWhoAreDirectors() throws SQLException {
        String sql = "SELECT DISTINCT p.full_name FROM persons p " +
                "WHERE p.id IN (SELECT actor_id FROM movie_cast) " + // Он актер
                "AND p.id IN (SELECT director_id FROM movies)";    // Он же режиссер
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            System.out.println("Актеры, которые также являются режиссерами:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("full_name"));
            }
        }
    }
}