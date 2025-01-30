package com.example.attendancetrackingsystem.controllers;

import com.example.attendancetrackingsystem.dto.GradeDto;
import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.repositories.StudentRepository;
import com.example.attendancetrackingsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    private StudentRepository studentRepository;

    @Autowired
    public GradeController(GradeService gradeService, StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.gradeService = gradeService;
    }

    @GetMapping
    public String viewGrades(Model model) {
        List<GradeDto> grades = gradeService.getAllGrades();
        model.addAttribute("grades", grades);

        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        model.addAttribute("today", LocalDate.now());
        return "grades/index";
    }

    @PostMapping("/add")
    public String addGrade(@ModelAttribute GradeDto gradeDto) {
        if (gradeDto.getGrade() == null) {
            throw new IllegalArgumentException("Grade must not be null");
        }
        gradeService.addGrade(gradeDto);
        return "redirect:/grades";
    }
}