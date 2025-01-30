package com.example.attendancetrackingsystem.controllers;

import com.example.attendancetrackingsystem.dto.AttendanceDto;
import com.example.attendancetrackingsystem.mappers.AttendanceMapper;
import com.example.attendancetrackingsystem.models.Attendance;
import com.example.attendancetrackingsystem.models.Session;
import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.service.AttendanceService;
import com.example.attendancetrackingsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/attendances")
public class AttendanceController {


    private final AttendanceService attendanceService;
    private  final StudentService studentService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService , StudentService studentService) {
        this.attendanceService = attendanceService;
        this.studentService = studentService;
    }
    @GetMapping
    public String showIndexPage(Model model) {
        List<Session> sessions = attendanceService.getAllSessions();
        model.addAttribute("usersessions", sessions);
        return "attendances/index";
    }

    @PostMapping("/session/create")
    public String createSession(@RequestParam String sessionName,
                                @RequestParam LocalDateTime startTime,
                                @RequestParam LocalDateTime endTime,
                                @RequestParam Long teacherId) {
        attendanceService.createSession(sessionName, startTime, endTime, teacherId);
        return "redirect:/attendances";
    }
    @PostMapping("/session/{sessionId}/delete")
    public String deleteSession(@PathVariable Long sessionId) {
        attendanceService.deleteSession(sessionId);
        return "redirect:/attendances";
    }

    @GetMapping("/session/{sessionId}/students")
    public String viewStudents(@PathVariable Long sessionId, Model model) {
        List<Student> students = attendanceService.getStudentsForSession(sessionId);
        System.out.println("Students for session " + sessionId + ": " + students);
        model.addAttribute("students", students);
        model.addAttribute("sessionId", sessionId);

        return "attendances/students";
    }

    @PostMapping("/session/{sessionId}/addStudents")
    public String addStudentsToSession(@PathVariable Long sessionId, @RequestParam("studentId") List<Long> studentIds) {
        attendanceService.addStudentsToSession(sessionId, studentIds);
        return "redirect:/attendances/session/{sessionId}/students";
    }



    @GetMapping("/session/{sessionId}/checkin/{studentId}")
    public String showCheckInPage(@PathVariable Long sessionId, @PathVariable Long studentId, Model model) {
        Student student = studentService.findStudentById(studentId);
        model.addAttribute("student", student);
        model.addAttribute("sessionId", sessionId);
        return "attendances/checkin";
    }

    // Procesi i Check-In
    @PostMapping("/session/{sessionId}/checkin")
    public String checkIn(@PathVariable Long sessionId, @RequestParam Long studentId, RedirectAttributes redirectAttributes) {
        try {
            attendanceService.updateAttendance(sessionId, studentId, true, false);
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/attendances/session/{sessionId}/students";
        }
        return "redirect:/attendances/session/{sessionId}/students";
    }




    @PostMapping("/session/{sessionId}/checkout")
    public String checkOut(@PathVariable Long sessionId, @RequestParam Long studentId) {
        attendanceService.updateAttendance(sessionId, studentId, false, true);
        return "redirect:/attendances/session/{sessionId}/students";
    }



}