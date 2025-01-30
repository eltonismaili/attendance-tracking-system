package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository  extends JpaRepository<Complaint, Long> {
}
