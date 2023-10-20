package com.example.LibraryManagementSystem.Library.Entities;

import java.util.Objects;

public class dtoAuthor {
    private  String ISBN;
    private  String bookTitle;
    private  String category;
    private  int quantity;
    private String authorName;
    private String authorEmail;

    public dtoAuthor() {
    }

    public dtoAuthor(String ISBN, String bookTitle, String category, int quantity, String authorName, String authorEmail) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.category = category;
        this.quantity = quantity;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dtoAuthor dteAuthor = (dtoAuthor) o;
        return quantity == dteAuthor.quantity && Objects.equals(ISBN, dteAuthor.ISBN) && Objects.equals(bookTitle, dteAuthor.bookTitle) && Objects.equals(category, dteAuthor.category) && Objects.equals(authorName, dteAuthor.authorName) && Objects.equals(authorEmail, dteAuthor.authorEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, bookTitle, category, quantity, authorName, authorEmail);
    }

    @Override
    public String toString() {
        return "dteAuthor{" +
                "ISBN='" + ISBN + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                '}';
    }
}
