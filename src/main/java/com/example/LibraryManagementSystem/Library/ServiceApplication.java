package com.example.LibraryManagementSystem.Library;

import com.example.LibraryManagementSystem.Library.Entities.Author;
import com.example.LibraryManagementSystem.Library.Entities.Book;
import com.example.LibraryManagementSystem.Library.Entities.Issue;
import com.example.LibraryManagementSystem.Library.Entities.Student;
import com.example.LibraryManagementSystem.Library.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Library.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Library.Repositories.IssueRepository;
import com.example.LibraryManagementSystem.Library.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication

public class ServiceApplication {

    @Autowired
    private static AuthorRepository authorRepository;

    @Autowired
    private static BookRepository bookRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private StudentRepository studentRepository;


    static void addBook(int isbn, String title, String category, String authorName, String authorEmail, int numOfBooks)
    {
        try{
            com.example.LibraryManagementSystem.Library.Entities.Book book = new Book(isbn, title, category, numOfBooks);
            bookRepository.save(book);
            Author author = new Author(authorName, authorEmail);
            author.setAuthorBook(book);
            book.setAuthor(author);
            authorRepository.save(author);
            System.out.println("Book added successfully"); //System.out.println("Book added");
        }
        catch (DataIntegrityViolationException e) {
            System.err.println(" An error occurred while adding the book. Please check if the ISBN already exists, then try again");
        }

    }


    public static void searchBookByTitle(Scanner scanner) {
//        System.out.print("Enter title to search: ");
//        String titleToSearch = scanner.nextLine();
//        List<Book> booksWithTitle = bookRepository.findByTitle(titleToSearch);
//
//        if (booksWithTitle.isEmpty()) {
//            System.out.println("No books found with the title: " + titleToSearch);
//        } else {
//            System.out.println("Books found with the title '" + titleToSearch + "':");
//            for (Book book : booksWithTitle) {
//                System.out.println(book);
//            }
//        }
    }

    public static void searchBookByCategory(Scanner scanner) {
//        System.out.print("Enter category to search: ");
//        String categoryToSearch = scanner.nextLine();
//        List<Book> booksWithCategory = bookRepository.findByCategory(categoryToSearch);
//
//        if (booksWithCategory.isEmpty()) {
//            System.out.println("No books found in the category: " + categoryToSearch);
//        } else {
//            System.out.println("Books found in the category '" + categoryToSearch + "':");
//            for (Book book : booksWithCategory) {
//                System.out.println(book);
//            }
//        }
//    }


//    public static void searchBookByAuthor() {
////        System.out.print("Enter author's name to search: ");
////        String authorNameToSearch = scanner.nextLine();
////        List<Book> booksByAuthor = bookRepository.findBooksByAuthorName(authorNameToSearch);
////
////        if (booksByAuthor.isEmpty()) {
////            System.out.println("No books found by author: " + authorNameToSearch);
////        } else {
////            System.out.println("Books found by author '" + authorNameToSearch + "':");
////            for (Book book : booksByAuthor) {
////                System.out.println(book);
////            }
////        }
//    }


//    public static void listAllBooks(BookRepository bookRepository) {
//        List<Book> allBooks = bookRepository.findAllBooksAndAuthors();
//
////        if (allBooks.isEmpty()) {
////            System.out.println("No books found in the library.");
////        } else {
////            System.out.println("All books in the library:");
////            for (Book book : allBooks) {
////                System.out.println("Title: " + book.getTitle());
////                System.out.println("Author: " + book.getAuthor().getName());
////                System.out.println("Category: " + book.getCategory());
////                System.out.println("Quantity: " + book.getQuantity());
////                System.out.println("ISBN: " + book.getIsbn());
////                System.out.println("----------------------------------");
////            }
////        }
//    }
//    public static void issueBookToStudent(Scanner scanner, IssueRepository issueRepository, BookRepository bookRepository, StudentRepository studentRepository) {
//        // Get input from the user (e.g., student's ID and book's ISBN)
//
//
//    }

  // public static void listBooksByUsn(Scanner scanner) {
        //add your code here}
    }
}



