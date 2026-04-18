import java.util.*;
import java.util.concurrent.*;

class Book {
    private final String title;
    private final boolean forHome;
    private final Semaphore semaphore = new Semaphore(1);

    public Book(String title, boolean forHome) {
        this.title = title;
        this.forHome = forHome;
    }

    public boolean tryBorrow() {
        return semaphore.tryAcquire();
    }

    public void release() {
        semaphore.release();
    }

    public String getTitle() { return title; }
    public boolean isForHome() { return forHome; }
}