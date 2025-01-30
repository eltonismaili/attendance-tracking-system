package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HourRepository extends JpaRepository<Session, Long> {
}
