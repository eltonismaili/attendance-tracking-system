package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Attendance;
import com.example.attendancetrackingsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findBySessionId(Long sessionId);
    Optional<Attendance> findBySessionIdAndStudentId(Long sessionId, Long studentId);
    List<Student> findBySessionIdAndCheckedInTrue(Long sessionId);


}

