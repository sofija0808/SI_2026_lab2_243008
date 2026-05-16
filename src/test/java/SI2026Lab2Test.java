import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {

        SI2026Lab2Code.Library library = new SI2026Lab2Code.Library();

        library.addBook(new SI2026Lab2Code.Book(
                "Crime and Punishment",
                "Fyodor Dostoevsky",
                "Classic"
        ));

        // prazen
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        assertEquals("Invalid title", exception.getMessage());

        // ne postoi
        List<SI2026Lab2Code.Book> result1 =
                library.searchBookByTitle("The Brothers Karamazov");

        assertNull(result1);

        // ok
        List<SI2026Lab2Code.Book> result2 =
                library.searchBookByTitle("Crime and Punishment");

        assertNotNull(result2);
        assertEquals(1, result2.size());
    }

    @Test
    public void borrowBookEveryBranchTest() {

        SI2026Lab2Code.Library library = new SI2026Lab2Code.Library();

        SI2026Lab2Code.Book book =
                new SI2026Lab2Code.Book(
                        "The Idiot",
                        "Fyodor Dostoevsky",
                        "Classic"
                );

        library.addBook(book);

        // ne validen
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // ok
        library.borrowBook("The Idiot", "Fyodor Dostoevsky");

        assertTrue(book.isBorrowed());

        // vise e zemena
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("The Idiot", "Fyodor Dostoevsky");
        });

        // ja nema
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Demons", "Fyodor Dostoevsky");
        });
    }

    @Test
    public void searchBookMultipleConditionTest() {

        SI2026Lab2Code.Library library = new SI2026Lab2Code.Library();

        SI2026Lab2Code.Book book =
                new SI2026Lab2Code.Book(
                        "White Nights",
                        "Fyodor Dostoevsky",
                        "Classic"
                );

        library.addBook(book);

        // T && T
        List<SI2026Lab2Code.Book> result1 =
                library.searchBookByTitle("White Nights");

        assertNotNull(result1);

        // T && F
        book.setBorrowed(true);

        List<SI2026Lab2Code.Book> result2 =
                library.searchBookByTitle("White Nights");

        assertNull(result2);

        // F && T
        book.setBorrowed(false);

        List<SI2026Lab2Code.Book> result3 =
                library.searchBookByTitle("Notes from Underground");

        assertNull(result3);

        // F && F
        book.setBorrowed(true);

        List<SI2026Lab2Code.Book> result4 =
                library.searchBookByTitle("Notes from Underground");

        assertNull(result4);
    }

    @Test
    public void borrowBookMultipleConditionTest() {

        SI2026Lab2Code.Library library = new SI2026Lab2Code.Library();

        library.addBook(new SI2026Lab2Code.Book(
                "Poor Folk",
                "Fyodor Dostoevsky",
                "Classic"
        ));

        // T || T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // T || F
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Fyodor Dostoevsky");
        });

        // F || T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Poor Folk", "");
        });

        // F || F
        assertDoesNotThrow(() -> {
            library.borrowBook("Poor Folk", "Fyodor Dostoevsky");
        });
    }
}