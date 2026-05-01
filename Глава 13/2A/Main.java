//. Видеотека. В БД хранится информация о домашней видеотеке: фильмы,актеры, режиссеры.
//Для фильмов необходимо хранить:
//• название;
//• имена актеров;
//• дату выхода;
//• страну, в которой выпущен фильм.
//• Для актеров и режиссеров необходимо хранить:
//• ФИО;
//• дату рождения.
//• Найти все фильмы, вышедшие на экран в текущем и прошлом году.
//• Вывести информацию об актерах, снимавшихся в заданном фильме.
//• Вывести информацию об актерах, снимавшихся как минимум в N фильмах.
//• Вывести информацию об актерах, которые были режиссерами хотя бы одного из фильмов.
//• Удалить все фильмы, дата выхода которых была более заданного числа лет назад.

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbInitializer.createTables(); //

        try (Connection conn = DbConnector.getConnection()) { //[cite: 10]
            Requests qm = new Requests(conn);
            Delete um = new Delete(conn);

            System.out.println("РЕЗУЛЬТАТЫ ЗАПРОСОВ");

            qm.printRecentMovies();
            System.out.println();

            qm.printActorsByMovie("Оппенгеймер");
            System.out.println();

            qm.printActorsWithMinMovies(2);
            System.out.println();

            qm.printActorsWhoAreDirectors();

            System.out.println("\nУДАЛЕНИЕ ДАННЫХ");
            um.deleteMoviesOlderThan(5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}