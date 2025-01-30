package com.example.attendancetrackingsystem.controllers;

import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(required = false) String errorId) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/index"; // Shablloni për listën e studentëve
    }

    @GetMapping("new")
    public String newStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new"; // Shablloni për krijimin e një studenti të ri
    }

    @PostMapping("new")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        studentService.addStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Student created successfully");
        return "redirect:/student";
    }

    @GetMapping("{id}/edit")
    public String editStudentForm(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "student/edit"; // Shablloni për modifikimin e studentit
    }

    @PostMapping("{id}/edit")
    public String updateStudent(@ModelAttribute Student student, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.modify(id, student);
        redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully");
        return "redirect:/student";
    }

    @GetMapping("{id}/delete")
    public String deleteStudentConfirmation(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "student/delete";
    }

    @PostMapping("{id}/delete")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully");
        return "redirect:/student";
    }

    @GetMapping("{id}/details")
    public String studentDetails(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findStudentById(id));
        return "student/details";
    }
}



