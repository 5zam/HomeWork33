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

import java.util.*;



@SpringBootApplication

public class ServiceApplication {

    @Autowired
    private static AuthorRepository authorRepository;

    @Autowired
    private static BookRepository bookRepository;

    @Autowired
    private static IssueRepository issueRepository;

    @Autowired
    private static StudentRepository studentRepository;

    private static Scanner scanner = new Scanner(System.in);


    static void addBook(String isbn, String title, String category, String authorName, String authorEmail, int numOfBooks) {
        try {
            // Check if the author already exists
            Author author = authorRepository.findByName(authorName);
            if (author == null) {
                author = new Author(authorName, authorEmail);
                authorRepository.save(author);
            }

            // Create the book
            Book book = new Book(isbn, title, category, numOfBooks);
            book.setAuthor(author);

            // Save the book
            bookRepository.save(book);

            System.out.println("Book added successfully");
        } catch (DataIntegrityViolationException e) {
            System.err.println("An error occurred while adding the book. Please check if the ISBN already exists.");
        }


    }


    public static void searchBookByTitle(Scanner scanner) {
        System.out.print("Enter title to search: ");
        String titleToSearch = scanner.nextLine();
        List<Book> booksWithTitle = bookRepository.findByTitle(titleToSearch);

        if (booksWithTitle.isEmpty()) {
            System.out.println("No books found with the title: " + titleToSearch);
        } else {
            System.out.println("Books found with the title '" + titleToSearch + "':");
            for (Book book : booksWithTitle) {
                System.out.println(book);
            }
        }
    }

    public static Book searchBookByCategory(String category) {
        return bookRepository.findByCategory(category);
    }


    public static void issueBookToStudent(String usn, String bookISBN, String name) {
        Student s = new Student(usn, name);
        studentRepository.save(s);
        Student student = studentRepository.findByUsn(usn);
        Book book = (Book) bookRepository.findByIsbn(bookISBN);
        if (student != null && book != null) {
// Calculate the return date (7 days from now)
            Calendar returnDate = Calendar.getInstance();
            returnDate.add(Calendar.DAY_OF_MONTH, 7);
            Issue issue = new Issue();
            issue.setIssueDate(new Date());
            issue.setReturnDate(returnDate.getTime());
            issue.setIssueStudent(student);
            issue.setIssueBook(book);
            book.setIssue(issue);
            issueRepository.save(issue);
            System.out.println(" Book issued. Return date: " + issue.getReturnDate());
        } else {
            System.err.println(" Student or book not found");
            return;

        }
    }

    public static void listBooksByUsn(Scanner scanner) {
    }

    public static void listAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> books = new ArrayList<>();


        if (allBooks.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            System.out.println("List of all books in the library:");
            for (Book book : allBooks) {
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Quantity: " + book.getQuantity());
                System.out.println("------------------------");
            }
        }
    }

    public static void searchBookByAuthor(String name) {
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






