package com.example.LibraryManagementSystem.Library;

import com.example.LibraryManagementSystem.Library.Entities.Author;
import com.example.LibraryManagementSystem.Library.Entities.Book;
import com.example.LibraryManagementSystem.Library.Entities.Issue;
import com.example.LibraryManagementSystem.Library.Entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementSystem {

	private static Book book = new Book();
	private static Author author = new Author();
	private static Student student = new Student();
	static Issue issue = new Issue();

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystem.class, args);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Menu Options:");
			System.out.println("1. Add a book");
			System.out.println("2. Search book by title");
			System.out.println("3. Search book by category");
			System.out.println("4. Search book by Author");
			System.out.println("5. List all books along with author");
			System.out.println("6. Issue book to student");
			System.out.println("7. List books by usn");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");

			int choice;
			try {
				choice = scanner.nextInt();
				scanner.nextLine();  // Consume newline character

			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();  // Clear the invalid input
				continue;
			}

			switch (choice) {

				case 1:
					ServiceApplication.addBook(scanner);
					break;

				case 2:
					ServiceApplication.searchBookByTitle(scanner);
					break;

				case 3:
					ServiceApplication.searchBookByCategory(scanner);
					break;

				case 4:
					ServiceApplication.searchBookByAuthor(scanner);
					break;

				case 5:
					ServiceApplication.listAllBooks(scanner);
					break;

				case 6:
					ServiceApplication.issueBookToStudent(scanner);
					break;

				case 7:
					ServiceApplication.listBooksByUsn(scanner);
				break;

				case 8:
					System.out.println("Exiting the program.");
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}


	}


}




