package com.example.LibraryManagementSystem.Library.Repositories;

import com.example.LibraryManagementSystem.Library.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName( String authorName);

}
