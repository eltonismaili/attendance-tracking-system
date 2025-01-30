package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.ComplaintDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ComplaintService {
    ComplaintDto createComplaint(ComplaintDto complaintDto);
    List<ComplaintDto> getAllComplaints();
}
