package com.example.LibraryManagementSystem.Library;

import com.example.LibraryManagementSystem.Library.Entities.Author;
import com.example.LibraryManagementSystem.Library.Entities.Book;
import com.example.LibraryManagementSystem.Library.Repositories.AuthorRepository;
import com.example.LibraryManagementSystem.Library.Repositories.BookRepository;
import com.example.LibraryManagementSystem.Library.Repositories.IssueRepository;
import com.example.LibraryManagementSystem.Library.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    public static void addBook(Scanner scanner) {
      //add your code here
    }


    public static void searchBookByTitle(Scanner scanner) {
        //add your code here
    }

    public static void searchBookByCategory(Scanner scanner) {

        System.out.print("Enter the category to search: ");
        String categoryToSearch = scanner.nextLine();
        Book result = bookRepository.findByCategory(categoryToSearch);

        //add your code here
    }


    public static void searchBookByAuthor(Scanner scanner) {
        System.out.print("Enter the author's name to search: ");
        String authorNameToSearch = scanner.nextLine();
        Book resulte1 = bookRepository.findByAuthorBook (authorNameToSearch);
        //add your code here
    }


    public static void listAllBooks(Scanner scanner) {
        //add your code here
    }
    public static void issueBookToStudent(Scanner scanner) {
        //add your code here

    }

    public static void listBooksByUsn(Scanner scanner) {
        //add your code here
    }
}



