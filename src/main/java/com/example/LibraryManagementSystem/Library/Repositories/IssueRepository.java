package com.example.LibraryManagementSystem.Library.Repositories;

import com.example.LibraryManagementSystem.Library.Entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IssueRepository extends JpaRepository<Issue, Long> {


    //    @Modifying
    //    @Query("INSERT INTO Issue (issueDate, returnDate, issueStudent, issueBook) " +
    //            "VALUES (:issueDate, :returnDate, :issueStudent, :issueBook)")
    //    Void issueBookToStudent(
    //            @Param("issueDate") LocalDate issueDate,
    //            @Param("returnDate") LocalDate returnDate,
    //            @Param("issueStudent") Student issueStudent,
    //            @Param("issueBook") Book issueBook
    //    );
    //    @Query("SELECT i.issueBook.title, s.name, i.returnDate FROM Issue i JOIN i.issueStudent s WHERE s.usn = :usn")
    //    List<Object[]> listBooksByUsn(@Param("usn") String usn);

//here
//    @Query("SELECT i FROM tbl_issue i WHERE i.student.id = :studentId AND i.book.isbn = :bookIsbn")
//    Issue issueBookToStudent(@Param("studentId") Long studentId, @Param("bookIsbn") String bookIsbn);
}
