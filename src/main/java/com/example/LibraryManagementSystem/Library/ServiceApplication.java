package com.example.LibraryManagementSystem.Library;

import com.example.LibraryManagementSystem.Library.Entities.Author;
import com.example.LibraryManagementSystem.Library.Entities.Issue;
import com.example.LibraryManagementSystem.Library.Entities.Student;
import com.example.LibraryManagementSystem.Library.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Library.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Library.Repositories.IssueRepository;
import com.example.LibraryManagementSystem.Library.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.time.LocalDate;
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

    public static void addBook(Scanner scanner) {
      //add your code here
    }


    public static void searchBookByTitle(Scanner scanner) {
        //add your code here
    }

    public static void searchBookByCategory(Scanner scanner) {
        //add your code here
    }


    public static void searchBookByAuthor(Scanner scanner) {
        //add your code here
    }


    public static void listAllBooks(Scanner scanner) {
        //add your code here
    }
    public static void issueBookToStudent(Scanner scanner) {
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
                issue.setIssueDate(LocalDate.now().toString());
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

    public static void listBooksByUsn(Scanner scanner) {
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



