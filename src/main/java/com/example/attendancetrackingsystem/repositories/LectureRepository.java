package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
