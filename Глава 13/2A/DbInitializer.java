import java.sql.Connection;
import java.sql.Statement;

public class DbInitializer {
    public static void createTables() {
        try (Connection conn = DbConnector.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("DROP ALL OBJECTS");

            st.execute("CREATE TABLE persons (id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "full_name VARCHAR(255), birth_date DATE)");

            st.execute("CREATE TABLE movies (id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255), " +
                    "release_date DATE, country VARCHAR(100), director_id INT, " +
                    "FOREIGN KEY (director_id) REFERENCES persons(id))");

            st.execute("CREATE TABLE movie_cast (movie_id INT, actor_id INT, " +
                    "PRIMARY KEY (movie_id, actor_id), " +
                    "FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (actor_id) REFERENCES persons(id) ON DELETE CASCADE)");

            st.execute("INSERT INTO persons (full_name, birth_date) VALUES " +
                    "('Кристофер Нолан', '1970-07-30'), " +
                    "('Киллиан Мерфи', '1976-05-25'), " +
                    "('Клинт Иствуд', '1930-05-31')"); // Иствуд и актер, и режиссер

            st.execute("INSERT INTO movies (title, release_date, country, director_id) VALUES " +
                    "('Оппенгеймер', '2023-07-21', 'USA', 1), " +
                    "('Гран Торино', '2008-12-12', 'USA', 3), " +
                    "('Тестовый фильм 2026', '2026-01-01', 'RU', 1)");

            st.execute("INSERT INTO movie_cast VALUES (1, 2), (2, 3), (3, 2)");

            System.out.println("База данных видеотеки успешно создана и заполнена.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}