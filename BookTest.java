package libraryapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testIssueReturnAvailability() {
        Book b = new Book("Title", "Author", "ISBN001");
        assertTrue(b.isAvailable(), "new book should be available");
        assertTrue(b.issueBook(), "issuing available book should return true");
        assertFalse(b.isAvailable(), "after issue, book should not be available");
        assertFalse(b.issueBook(), "issuing already issued book should return false");
        assertTrue(b.returnBook(), "returning issued book should return true");
        assertTrue(b.isAvailable(), "after return, book should be available");
        assertFalse(b.returnBook(), "returning already available book should return false");
    }

    @Test
    public void testEqualsAndHashCode() {
        Book b1 = new Book("A", "B", "ISBNX");
        Book b2 = new Book("A2", "B2", "ISBNX");
        assertEquals(b1, b2, "books with same ISBN should be equal");
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    public void testConstructorNullChecks() {
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "a", "i"));
        assertThrows(IllegalArgumentException.class, () -> new Book("a", null, "i"));
        assertThrows(IllegalArgumentException.class, () -> new Book("a", "b", null));
    }
}
