package com.example.LibraryManagementSystem.Library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.title, b.isbn, b.category, b.quantity, a.name, a.email FROM Book b JOIN b.author a")
    List<Object[]> listBooksAndAuthors();


}
