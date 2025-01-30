package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.models.Student;


import java.util.List;

public interface StudentService {


    public List<Student> getAllStudents();

    public Student findStudentById(Long id);

    public Student addStudent(Student student);

    public Student modify(Long id, Student student);

    public void deleteStudent(Long id);

    public Student findByEmail(String email);


}
