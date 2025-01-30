package com.example.attendancetrackingsystem.controllers.api.v1;


import com.example.attendancetrackingsystem.dto.ComplaintDto;
import com.example.attendancetrackingsystem.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintRestController {

    private final ComplaintService complaintService;

    public ComplaintRestController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping
    public List<ComplaintDto> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @PostMapping
    public ComplaintDto createComplaint(@RequestBody ComplaintDto complaintDto) {
        return complaintService.createComplaint(complaintDto);
    }
}
