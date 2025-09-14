package libraryapp;

import java.util.*;

public class Library {
    private final Map<String, Book> booksByIsbn = new HashMap<>();

    public Library() {}

    public synchronized void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("book cannot be null");
        booksByIsbn.put(book.getIsbn(), book);
    }

    public synchronized boolean issueBook(String isbn) {
        Book b = booksByIsbn.get(isbn);
        if (b == null) throw new NoSuchElementException("Book with ISBN " + isbn + " not found");
        return b.issueBook();
    }

    public synchronized boolean returnBook(String isbn) {
        Book b = booksByIsbn.get(isbn);
        if (b == null) throw new NoSuchElementException("Book with ISBN " + isbn + " not found");
        return b.returnBook();
    }

    public synchronized boolean isAvailable(String isbn) {
        Book b = booksByIsbn.get(isbn);
        if (b == null) throw new NoSuchElementException("Book with ISBN " + isbn + " not found");
        return b.isAvailable();
    }

    public synchronized Optional<Book> getBook(String isbn) {
        return Optional.ofNullable(booksByIsbn.get(isbn));
    }

    public synchronized List<Book> listAll() {
        return new ArrayList<>(booksByIsbn.values());
    }

    public synchronized List<Book> listAvailable() {
        List<Book> list = new ArrayList<>();
        for (Book b : booksByIsbn.values()) {
            if (b.isAvailable()) list.add(b);
        }
        return list;
    }
}
