package libraryapp;

public class Book implements Issueable {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        if (title == null || author == null || isbn == null) {
            throw new IllegalArgumentException("Title, author and ISBN cannot be null");
        }
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.available = true; // new books start available
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public synchronized boolean issueBook() {
        if (!available) return false;
        available = false;
        return true;
    }

    @Override
    public synchronized boolean returnBook() {
        if (available) return false;
        available = true;
        return true;
    }

    @Override
    public synchronized boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', isbn='%s', available=%s}", title, author, isbn, available);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return isbn.equals(b.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
