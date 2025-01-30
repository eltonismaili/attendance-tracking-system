package com.example.attendancetrackingsystem.controllers.api.v1;

import com.example.attendancetrackingsystem.dto.AttendanceDto;
import com.example.attendancetrackingsystem.dto.SessionDto;
import com.example.attendancetrackingsystem.mappers.AttendanceMapper;
import com.example.attendancetrackingsystem.mappers.SessionMapper;
import com.example.attendancetrackingsystem.models.Attendance;

import com.example.attendancetrackingsystem.models.Session;
import com.example.attendancetrackingsystem.models.Teacher;
import com.example.attendancetrackingsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceControllerApi {


    private final AttendanceService attendanceService;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public AttendanceControllerApi(AttendanceService attendanceService, AttendanceMapper attendanceMapper) {
        this.attendanceService = attendanceService;
        this.attendanceMapper = attendanceMapper;
    }

    // Get attendance for a specific session
    @GetMapping("/session/{sessionId}")
    public List<AttendanceDto> getAttendanceForSession(@PathVariable Long sessionId) {
        return attendanceService.getAttendanceForSession(sessionId);
    }

    // Update check-in and check-out status for a student
    @PostMapping("/update/{attendanceId}")
    public AttendanceDto updateAttendance(@PathVariable Long attendanceId,
                                          @RequestParam Long sessionId,
                                          @RequestParam Long studentId,
                                          @RequestParam(required = false) Boolean checkIn,
                                          @RequestParam(required = false) Boolean checkOut) {

        // Sigurohemi që checkIn dhe checkOut të kenë vlera nëse nuk janë të dërguara
        if (checkIn == null) {
            checkIn = false;  // Default vlerë nëse checkIn nuk është dërguar
        }
        if (checkOut == null) {
            checkOut = false;  // Default vlerë nëse checkOut nuk është dërguar
        }

        return attendanceService.updateAttendance(sessionId, studentId, checkIn, checkOut);
    }

}

