package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findById(Long id);

//    List<Student> findByTeacher(Teacher teacher);
    List<Student> findAll();
}
