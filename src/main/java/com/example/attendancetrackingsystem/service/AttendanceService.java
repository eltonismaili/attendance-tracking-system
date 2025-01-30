package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.AttendanceDto;
import com.example.attendancetrackingsystem.models.Attendance;
import com.example.attendancetrackingsystem.models.Session;
import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.models.Teacher;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {

    Session createSession(String name, LocalDateTime startTime, LocalDateTime endTime, Long teacherId);
    List<AttendanceDto> getAttendanceForSession(Long sessionId);
    AttendanceDto updateAttendance(Long sessionId, Long studentId, boolean checkIn, boolean checkOut);
    public void addStudentsToSession(Long sessionId, List<Long> studentIds);
    public List<AttendanceDto> getAllAttendances();
    public List<Session> getAllSessions();

    public List<Student> getStudentsForSession(Long sessionId);
    public List<Student> getCheckedInStudentsForSession(Long sessionId);
    public Session deleteSession(Long sessionId);
    public Student getStudentById(Long studentId);


}
