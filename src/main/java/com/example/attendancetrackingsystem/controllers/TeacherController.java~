package com.example.attendancetrackingsystem.controllers;


import com.example.attendancetrackingsystem.dto.TeacherDto;
import com.example.attendancetrackingsystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teacher/index"; // Template for the list of teachers
    }

    @GetMapping("new")
    public String newTeacherForm(Model model) {
        model.addAttribute("teacherDto", new TeacherDto()); // Use TeacherDto
        return "teacher/new"; // Template for creating a new teacher
    }

    @PostMapping("new")
    public String createTeacher(@ModelAttribute TeacherDto teacherDto, RedirectAttributes redirectAttributes) {
        teacherService.createTeacher(teacherDto); // Pass TeacherDto
        redirectAttributes.addFlashAttribute("successMessage", "Teacher created successfully");
        return "redirect:/teacher";
    }

    @GetMapping("{id}/edit")
    public String editTeacherForm(Model model, @PathVariable Long id) {
        model.addAttribute("teacherDto", teacherService.getTeacherById(id)); // Use TeacherDto
        return "teacher/edit"; // Template for editing the teacher
    }

    @PostMapping("{id}/edit")
    public String updateTeacher(@ModelAttribute TeacherDto teacherDto, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        teacherService.updateTeacher(id, teacherDto); // Pass TeacherDto
        redirectAttributes.addFlashAttribute("successMessage", "Teacher updated successfully");
        return "redirect:/teacher";
    }

    @GetMapping("{id}/delete")
    public String deleteTeacherConfirmation(Model model, @PathVariable Long id) {
        model.addAttribute("teacherDto", teacherService.getTeacherById(id)); // Use TeacherDto
        return "teacher/delete"; // Template for confirmation of deletion
    }

    @PostMapping("{id}/delete")
    public String deleteTeacher(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        teacherService.deleteTeacher(id);
        redirectAttributes.addFlashAttribute("successMessage", "Teacher deleted successfully");
        return "redirect:/teacher";
    }

    @GetMapping("{id}/details")
    public String teacherDetails(Model model, @PathVariable Long id) {
        model.addAttribute("teacherDto", teacherService.getTeacherById(id)); // Use TeacherDto
        return "teacher/details"; // Template for teacher details
    }
}