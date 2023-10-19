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

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication

public class ServiceApplication {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private static BookRepository bookRepository;

    @Autowired
    private static IssueRepository issueRepository;

    @Autowired
    private static StudentRepository studentRepository;


    static void addBook(int isbn, String title, String category, String authorName, String authorEmail, int numOfBooks) {
//

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
    }


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


        public static void listAllBooks (Scanner scanner){
            //add your code here
        }
        public static void issueBookToStudent (Scanner scanner){
            System.out.print("Enter book ISBN: ");
            String isbn = scanner.next();

            System.out.print("Enter student USN: ");
            String usn = scanner.next();

            // Fetch the book and student from the database based on ISBN and USN
            Book book = bookRepository.findByIsbn(isbn);
            Student student = studentRepository.findByUsn(usn);
            if (book == null) {
                System.out.println("Book with ISBN " + isbn + " not found.");
            } else if (student == null) {
                System.out.println("Student with USN " + usn + " not found.");
            } else {
                // Check if the book is available
                if (book.getQuantity() > 0) {
                    // Issue the book to the student
                    Issue issue = new Issue();

                    issue.setIssueDate(new Date());
                    issue.setIssueStudent(student);
                    issue.setIssueBook(book);
                    // Update book quantity
                    book.setQuantity(book.getQuantity() - 1);

                    // Save the issue and book updates to the database
                    issueRepository.save(issue);
                    bookRepository.save(book);
                    System.out.println("Book with ISBN " + isbn + " issued to student with USN " + usn);
                } else {
                    System.out.println("Book with ISBN " + isbn + " is not available for issue.");
                }
            }
        }

        public static void listBooksByUsn (Scanner scanner){
            System.out.print("Enter student USN: ");
            String usn = scanner.next();

            // Fetch the student from the database based on USN
            Student student = studentRepository.findByUsn(usn);

            if (student == null) {
                System.out.println("Student with USN " + usn + " not found.");
            } else {
                // Fetch books issued to the student
                List<Issue> issuedBooks = issueRepository.findByStudent(student);

                if (issuedBooks.isEmpty()) {
                    System.out.println("No books issued to the student with USN " + usn);
                } else {
                    System.out.println("Books issued to the student with USN " + usn + ":");
                    for (Issue issue : issuedBooks) {
                        System.out.println("ISBN: " + issue.getIssueBook().getIsbn() + ", Title: " + issue.getIssueBook().getTitle());
                    }
                }
            }

        }
    }




