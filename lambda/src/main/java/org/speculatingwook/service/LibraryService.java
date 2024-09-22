package org.speculatingwook.service;

import org.speculatingwook.book.BookProcessor;
import org.speculatingwook.book.BookTransformer;
import org.speculatingwook.book.BookValidator;
import org.speculatingwook.domain.Book;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findBooks(Predicate<Book> predicate) {
        return null;
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return null;
    }

    public Map<String, List<Book>> groupBooksByAuthor() {
        return null;
    }

    /**
     * flatMap, groupingBy(Function.identity(), Collectors.counting())
     * @return
     */
    public Map<String, Long> countBooksByCategory() {
        return null;
    }

    /**
     * limit, sorted
     * @param n
     * @return
     */
    public List<String> getMostPopularCategories(int n) {
        return null;
    }

    /**
     * mapToLong
     * @return
     */
    public double getAverageBookAge() {
        return 0;
    }

    /**
     * sorted, limit
     * @param n
     * @return
     */
    public List<Book> getRecentBooks(int n) {
        return null;
    }

    public boolean lendBook(String isbn) {
        return findBookByIsbn(isbn).map(book -> {
            if (book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
            return false;
        }).orElse(false);
    }

    public void returnBook(String isbn) {

    }

    public Map<Boolean, List<Book>> partitionBooksByAvailability() {
        return null;
    }

    /**
     * reducing 사용하기
     * @return
     */
    public int getTotalTitleLength() {
        return 0;
    }

    /**
     * entrySet, max, map
     * @return
     */
    public String getMostProlificAuthor() {
        return null;
    }

    // 커스텀 BookProcessor를 사용하여 책을 처리합니다.
    public void processBooks(BookProcessor processor) {
        books.forEach(processor::process);
    }

    // BookValidator를 사용하여 책을 검증합니다.
    public List<Book> getValidBooks(BookValidator validator) {
        return books.stream()
                .filter(validator::validate)
                .collect(Collectors.toList());
    }

    // BookTransformer를 사용하여 책을 변환합니다.
    public <T> List<T> transformBooks(BookTransformer<T> transformer) {
        return books.stream()
                .map(transformer::transform)
                .collect(Collectors.toList());
    }

    // Supplier를 사용하여 새 책을 생성합니다.
    public void addNewBook(Supplier<Book> bookSupplier) {

    }

    // BiFunction을 사용하여 두 개의 책을 비교합니다.
    public <T> T compareBooks(Book book1, Book book2, BiFunction<Book, Book, T> comparator) {
        return null;
    }

    // UnaryOperator를 사용하여 책의 상태를 업데이트합니다.
    public void updateBookState(String isbn, UnaryOperator<Book> updater) {
        findBookByIsbn(isbn).ifPresent(book -> {
            Book updatedBook = updater.apply(book);
            int index = books.indexOf(book);
            if (index != -1) {
                books.set(index, updatedBook);
            }
        });
    }
}
