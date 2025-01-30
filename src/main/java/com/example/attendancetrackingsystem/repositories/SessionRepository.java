package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByTeacherId(Long teacherId);
}
