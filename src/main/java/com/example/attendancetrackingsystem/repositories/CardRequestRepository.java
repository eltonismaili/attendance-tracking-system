package com.example.attendancetrackingsystem.repositories;

import com.example.attendancetrackingsystem.models.CardRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardRequestRepository extends JpaRepository<CardRequest, Long> {

}
