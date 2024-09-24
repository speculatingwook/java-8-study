package org.speculatingwook.library;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishDate;
    private List<String> categories;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, LocalDate publishDate, List<String> categories) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.categories = categories;
        this.isAvailable = true;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public LocalDate getPublishDate() { return publishDate; }
    public List<String> getCategories() { return categories; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", categories=" + categories +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
