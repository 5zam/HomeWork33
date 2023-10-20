package com.example.LibraryManagementSystem.Library.Entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_books")
public class Book {
    @Id
    private String isbn;
    private String title;
    private String category;
    private int quantity;

    @OneToOne
    private Issue issue;

    @OneToOne
    private Author author;

    public Book() {
    }

    public Book(String isbn, String title, String category, int quantity, Issue issue, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
        this.issue = issue;
        this.author = author;
    }

    public Book(String isbn, String title, String category, int numOfBooks) {
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return quantity == book.quantity && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(category, book.category) && Objects.equals(issue, book.issue) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, category, quantity, issue, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", issue=" + issue +
                ", author=" + author +
                '}';
    }
}
