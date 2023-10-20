package com.example.LibraryManagementSystem.Library.Repositories;

import com.example.LibraryManagementSystem.Library.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    static void save(int s) {
    }
//    static void save(int s) {
//    }

    //Student findByUsn(String usn);


    Student findByUsn(String usn);
}
