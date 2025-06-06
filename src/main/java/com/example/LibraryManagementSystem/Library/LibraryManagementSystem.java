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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;




@SpringBootApplication
@ComponentScan(basePackages = "com.example.LibraryManagementSystem.Library")
public class LibraryManagementSystem {

	@Autowired
	private static AuthorRepository authorRepository;

	@Autowired
	private static BookRepository bookRepository;

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private StudentRepository studentRepository;
//	private static Book book = new Book();
//	//private static Author author = new Author();
//	private static Student student = new Student();
//	static Issue issue = new Issue();
	public List<Author> authors;
	public List<Student> students;
	public List<Issue> issues;

	public  LibraryManagementSystem(BookRepository bookRepository, AuthorRepository authorRepository, IssueRepository issueRepository){
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
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
					System.out.print(" Enter isbn book: ");
					String isbn = scanner.nextLine();
					scanner.nextLine(); System.out.print(" Enter title of the book: ");
					String title = scanner.nextLine(); System.out.print(" Enter the category: ");
					String category = scanner.nextLine(); System.out.print(" Enter Author name: ");
					String authorName = scanner.nextLine(); System.out.print(" Enter Author email: ");
					String authorEmail = scanner.nextLine(); System.out.print(" Enter number of books: ");
					int numOfBooks = scanner.nextInt();
					ServiceApplication.addBook(isbn, title, category, authorName, authorEmail, numOfBooks);

					break;

				case 2:
					System.out.print(" Enter the Title: ");
					title=scanner.nextLine();
				ServiceApplication.searchBookByTitle(scanner);
					break;

				case 3:
					System.out.print(" Enter the category: ");
					category = scanner.nextLine();
					ServiceApplication.searchBookByCategory(category);
					break;

				case 4:
					System.out.print(" Enter the author's name: ");
                    String name = scanner.nextLine();
					ServiceApplication.searchBookByAuthor(name);
					break;

				case 5:
					ServiceApplication.listAllBooks();
					break;

				case 6:
					scanner.nextLine();
					System.out.print(" Enter usn: ");
					String usn = scanner.nextLine(); System.out.print(" Enter name: ");
					name = scanner.nextLine(); System.out.print(" Enter  book ISBN: ");
					String bookISBN = String.valueOf(scanner.nextInt());
					ServiceApplication.issueBookToStudent(usn , bookISBN , name);

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




