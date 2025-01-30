package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.AttendanceDto;
import com.example.attendancetrackingsystem.models.Attendance;
import com.example.attendancetrackingsystem.models.Session;
import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.models.Teacher;
import com.example.attendancetrackingsystem.repositories.*;
import com.example.attendancetrackingsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Session createSession(String name, LocalDateTime startTime, LocalDateTime endTime, Long teacherId) {
        Session session = new Session();
        session.setName(name);
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        session.setTeacher(teacher);
        session = sessionRepository.save(session);

        // Regjistro të gjithë studentët për këtë seancë
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            Attendance attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setSession(session);
            attendance.setDate(LocalDate.now());
            attendance.setCheckIn(false);  // Default value
            attendance.setCheckOut(false);  // Default value
            attendanceRepository.save(attendance);
        }

        return session;
    }

    @Override
    public Session deleteSession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        sessionRepository.delete(session);
        return session;
    }

    @Override
    public List<Student> getStudentsForSession(Long sessionId) {
        return studentRepository.findAll();
    }



    @Override
    public void addStudentsToSession(Long sessionId, List<Long> studentIds) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        List<Student> studentsToAdd = studentRepository.findAllById(studentIds);

        // Sigurohemi që studentët të mos jenë tashmë pjesë e sesionit
        List<Student> existingStudents = session.getStudents();
        List<Student> newStudents = studentsToAdd.stream()
                .filter(student -> !existingStudents.contains(student))
                .collect(Collectors.toList());

        // Shtimi i studentëve në sesion
        session.getStudents().addAll(newStudents);
        sessionRepository.save(session);

        // Krijimi i Attendance për studentët e rinj
        for (Student student : newStudents) {
            Attendance attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setSession(session);
            attendance.setDate(LocalDate.now());
            attendance.setCheckIn(false);
            attendance.setCheckOut(false);
            attendanceRepository.save(attendance);
        }
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
    @Override
    public List<AttendanceDto> getAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<AttendanceDto> getAttendanceForSession(Long sessionId) {
        List<Attendance> attendances = attendanceRepository.findBySessionId(sessionId);
        return attendances.stream().map(this::convertToDto).collect(Collectors.toList());
    }



    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
    @Override
    public AttendanceDto updateAttendance(Long sessionId, Long studentId, boolean checkIn, boolean checkOut) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance attendance = attendanceRepository.findBySessionIdAndStudentId(sessionId, studentId)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));

        // Logika për check-in dhe check-out
        if (checkIn) {
            LocalDateTime now = LocalDateTime.now();
            if (now.isBefore(session.getStartTime()) || now.isAfter(session.getEndTime())) {
                throw new RuntimeException("Check-in is only allowed during session time!");
            }
            attendance.setCheckIn(true);
        }
        if (checkOut) {
            attendance.setCheckOut(true);
        }

        attendanceRepository.save(attendance);
        return convertToDto(attendance);
    }




    @Override
    public List<Student> getCheckedInStudentsForSession(Long sessionId) {
        return attendanceRepository.findBySessionIdAndCheckedInTrue(sessionId);
    }
    private AttendanceDto convertToDto(Attendance attendance) {
        AttendanceDto dto = new AttendanceDto();
        dto.setAttendanceId(attendance.getId());
        dto.setStudentId(attendance.getStudent().getId());
        dto.setStudentName(attendance.getStudent().getFirstName() + " " + attendance.getStudent().getLastName());
        dto.setSessionId(attendance.getSession().getId());
        dto.setSessionName(attendance.getSession().getName());
        dto.setCheckIn(attendance.isCheckIn());
        dto.setCheckOut(attendance.isCheckOut());
        return dto;
    }
}
