import java.sql.*;

public class Delete {
    private Connection conn;

    public Delete(Connection conn) {
        this.conn = conn;
    }

    public void deleteMoviesOlderThan(int years) throws SQLException {
        String sql = "DELETE FROM movies WHERE release_date < DATEADD('YEAR', ?, CURDATE())";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, -years); // Отрицательное число лет от текущей даты
            int rows = ps.executeUpdate();
            System.out.println("Удалено фильмов старше " + years + " лет: " + rows);
        }
    }
}