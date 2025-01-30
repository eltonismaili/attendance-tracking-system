package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.CardRequestDto;
import com.example.attendancetrackingsystem.models.CardRequest;

import java.util.List;
import java.util.Optional;

public interface CardRequestService {
    void createCardRequest(CardRequestDto cardRequestDto);
    List<CardRequest> getAllCardRequests();
}
