package com.example.LibraryManagementSystem.Library.Entities.Repositories;

import com.example.LibraryManagementSystem.Library.Entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
