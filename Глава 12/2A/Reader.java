import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Reader extends Thread {
    private final String name;
    private final List<Book> libraryBooks;
    private final List<Book> takenBooks = new ArrayList<>();

    public Reader(String name, List<Book> books) {
        this.name = name;
        this.libraryBooks = books;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                Book book = libraryBooks.get(ThreadLocalRandom.current().nextInt(libraryBooks.size()));
                if (book.tryBorrow()) {
                    takenBooks.add(book);
                    String place = book.isForHome() ? "на руки" : "в зал";
                    System.out.println(name + " взял книгу: " + book.getTitle() + " (" + place + ")");
                }
            }

            if (!takenBooks.isEmpty()) {
                Thread.sleep(1000);
                System.out.println(name + " прочитал и возвращает книги.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            for (Book b : takenBooks) {
                b.release();
            }
        }
    }
}
