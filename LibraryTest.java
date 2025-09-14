package libraryapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class LibraryTest {
    private Library lib;
    private Book book;

    @BeforeEach
    public void setup() {
        lib = new Library();
        book = new Book("Test", "Me", "ISBN-LIB-1");
        lib.addBook(book);
    }

    @Test
    public void testIssueAndReturnFromLibrary() {
        assertTrue(lib.isAvailable(book.getIsbn()));
        assertTrue(lib.issueBook(book.getIsbn()));
        assertFalse(lib.isAvailable(book.getIsbn()));
        assertFalse(lib.issueBook(book.getIsbn())); // already issued
        assertTrue(lib.returnBook(book.getIsbn()));
        assertTrue(lib.isAvailable(book.getIsbn()));
    }

    @Test
    public void testGetBookNotFoundThrows() {
        assertThrows(NoSuchElementException.class, () -> lib.issueBook("no-such-isbn"));
    }
}
