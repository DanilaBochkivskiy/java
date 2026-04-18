import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Book> books = Arrays.asList(
            new Book("Алгоритмы", true),
            new Book("Философия Java", false),
            new Book("Чистый код", true),
            new Book("Дюна", false)
    );

    for (int i = 1; i <= 5; i++) {
      new Reader("Читатель-" + i, books).start();
    }
  }
}