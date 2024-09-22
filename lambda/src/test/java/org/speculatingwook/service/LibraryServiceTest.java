package org.speculatingwook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.speculatingwook.book.BookProcessor;
import org.speculatingwook.book.BookTransformer;
import org.speculatingwook.book.BookValidator;
import org.speculatingwook.domain.Book;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {
    private LibraryService libraryService;

    @BeforeEach
    public void setUp() {
        libraryService = new LibraryService();
        libraryService.addBook(new Book("1984", "George Orwell", "1234", LocalDate.of(1949, 6, 8), Arrays.asList("Dystopian", "Political fiction")));
        libraryService.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "5678", LocalDate.of(1960, 7, 11), Arrays.asList("Southern Gothic", "Bildungsroman")));
        libraryService.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9101", LocalDate.of(1925, 4, 10), Arrays.asList("Tragedy", "Social criticism")));
        libraryService.addBook(new Book("Animal Farm", "George Orwell", "1121", LocalDate.of(1945, 8, 17), Arrays.asList("Political satire", "Allegory")));
        libraryService.addBook(new Book("Brave New World", "Aldous Huxley", "3141", LocalDate.of(1932, 1, 1), Arrays.asList("Dystopian", "Science fiction")));
    }

    @Test
    public void testFindBooks() {
        List<Book> dystopianBooks = libraryService.findBooks(book -> book.getCategories().contains("Dystopian"));
        assertEquals(2, dystopianBooks.size());
    }

    @Test
    public void testGroupBooksByAuthor() {
        Map<String, List<Book>> booksByAuthor = libraryService.groupBooksByAuthor();
        assertEquals(2, booksByAuthor.get("George Orwell").size());
    }

    @Test
    public void testCountBooksByCategory() {
        Map<String, Long> categoryCount = libraryService.countBooksByCategory();
        assertEquals(2L, (long) categoryCount.get("Dystopian"));
    }

    @Test
    public void testGetMostPopularCategories() {
        List<String> popularCategories = libraryService.getMostPopularCategories(3);
        assertEquals(3, popularCategories.size());
        assertTrue(popularCategories.contains("Dystopian"));
    }

    @Test
    public void testGetAverageBookAge() {
        double averageAge = libraryService.getAverageBookAge();
        assertTrue(averageAge > 60 && averageAge < 100);
    }

    @Test
    public void testGetRecentBooks() {
        List<Book> recentBooks = libraryService.getRecentBooks(2);
        assertEquals(2, recentBooks.size());
        assertTrue(recentBooks.get(0).getPublishDate().isAfter(recentBooks.get(1).getPublishDate()));
    }

    @Test
    public void testLendAndReturnBook() {
        assertTrue(libraryService.lendBook("1234"));
        assertFalse(libraryService.lendBook("1234"));
        libraryService.returnBook("1234");
        assertTrue(libraryService.lendBook("1234"));
    }

    @Test
    public void testPartitionBooksByAvailability() {
        libraryService.lendBook("1234");
        Map<Boolean, List<Book>> partitionedBooks = libraryService.partitionBooksByAvailability();
        assertEquals(4, partitionedBooks.get(true).size());
        assertEquals(1, partitionedBooks.get(false).size());
    }

    @Test
    public void testGetMostProlificAuthor() {
        String prolificAuthor = libraryService.getMostProlificAuthor();
        assertEquals("George Orwell", prolificAuthor);
    }

    @Test
    public void testGetTotalTitleLength() {
        int totalTitleLength = libraryService.getTotalTitleLength();
        assertEquals(67, totalTitleLength);
    }

    // 함수형 인터페이스 학습 테스트

    @Test
    public void testProcessBooks() {
        final int[] count = {0};
        BookProcessor countProcessor = book -> {
            // TODO: 이 부분을 완성하세요.
        };
        libraryService.processBooks(countProcessor);
        assertEquals(5, count[0]);
    }

    /**
     * 1950년 1월 1일 이후에 출판 된 책을 가져오기
     */
    @Test
    public void testGetValidBooks() {
        BookValidator recentBookValidator = book -> {
            // TODO: 이 부분을 완성하세요.
            return false; // 이 부분을 적절히 수정하세요.
        };
        List<Book> recentBooks = libraryService.getValidBooks(recentBookValidator);
        assertEquals(1, recentBooks.size());
    }

    @Test
    public void testTransformBooks() {
        BookTransformer<String> titleTransformer = book -> {
            return ""; // 이 부분을 적절히 수정하세요.
        };
        List<String> titles = libraryService.transformBooks(titleTransformer);
        assertEquals(Arrays.asList("1984", "To Kill a Mockingbird", "The Great Gatsby", "Animal Farm", "Brave New World"), titles);
    }

    /**
     * book name: The Catcher in the Rye
     * author: J.D. Salinger
     * date: 1951.7.16
     * categories: Coming-of-age, Realistic fiction
     * 위 책을 추가해야 합니다.
     */
    @Test
    public void testAddNewBook() {
        Supplier<Book> newBookSupplier = () -> {
            // TODO: 이 부분을 완성하세요.
            return null; // 이 부분을 적절히 수정하세요.
        };
        libraryService.addNewBook(newBookSupplier);
        assertEquals(6, libraryService.findBooks(book -> true).size());
    }

    @Test
    public void testCompareBooks() {
        Book book1 = libraryService.findBookByIsbn("1234").orElseThrow();
        Book book2 = libraryService.findBookByIsbn("5678").orElseThrow();
        BiFunction<Book, Book, Boolean> publishDateComparator = (b1, b2) -> {
            // TODO: 이 부분을 완성하세요.
            return false; // 이 부분을 적절히 수정하세요.
        };
        assertTrue(libraryService.compareBooks(book1, book2, publishDateComparator));
    }

    @Test
    public void testUpdateBookState() {
        UnaryOperator<Book> makeUnavailable = book -> {
            // TODO: 이 부분을 완성하세요.
            return book; // 이 부분을 적절히 수정하세요.
        };
        libraryService.updateBookState("1234", makeUnavailable);
        assertFalse(libraryService.findBookByIsbn("1234").orElseThrow().isAvailable());
    }
}
