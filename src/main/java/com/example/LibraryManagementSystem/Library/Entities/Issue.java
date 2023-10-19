package com.example.LibraryManagementSystem.Library.Entities;


import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tbl_issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date issueDate;
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "issue_Student")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "issue_Book")
    private Book issueBook;

    public Issue() {
    }

    public Issue(Long id, Date issueDate, Date returnDate, Student issueStudent, Book issueBook) {
        this.id = id;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueStudent = issueStudent;
        this.issueBook = issueBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return Objects.equals(id, issue.id) && Objects.equals(issueDate, issue.issueDate) && Objects.equals(returnDate, issue.returnDate) && Objects.equals(issueStudent, issue.issueStudent) && Objects.equals(issueBook, issue.issueBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueDate, returnDate, issueStudent, issueBook);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", issueStudent=" + issueStudent +
                ", issueBook=" + issueBook +
                '}';
    }
}
