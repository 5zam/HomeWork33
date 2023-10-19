package com.example.LibraryManagementSystem.Library.Repositories;

import com.example.LibraryManagementSystem.Library.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

=======
import org.springframework.stereotype.Repository;
>>>>>>> ca2e14af660d730637d0f2bb8169a313d8415ba5

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //just for error




    //example:
    //    Book findByIsbn(int isbn);
    //    Book findByTitle(String title);
    //    Book findByCategory(String category);
    //    Book findByAuthorName(String name);
    //    @Query("SELECT b.title, b.isbn, b.category, b.quantity, a.name, a.email FROM Book b JOIN b.author a")
    //    List<Object[]> listBooksAndAuthors();



    //here
//    @Query("SELECT b.title, b.isbn, b.category, b.quantity, a.name, a.email FROM tbl_books b JOIN b.author a")
//    List<Object[]> listBooksAndAuthors();
//
//    List<Book> findByTitle(String title);
//
//    List<Book> findByCategory(String category);
//
//    @Query("SELECT b FROM tbl_books b WHERE b.category = :category")
//    List<Book> findBooksByCategory(@Param("category") String category);
//
//    List<Book> findByAuthorName(String authorName);
//
//    @Query("SELECT b FROM tbl_books b WHERE b.author.name = :authorName")
//    List<Book> findBooksByAuthorName(@Param("authorName") String authorName);
//
//    @Query("SELECT b FROM tbl_books b JOIN FETCH b.author")
//    List<Book> findAllBooksAndAuthors();
//
//    Book findByIsbn(String bookIsbn);



    Book findByIsbn(String isbn);
}
