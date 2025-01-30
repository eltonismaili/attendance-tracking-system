package com.example.attendancetrackingsystem.controllers;


import com.example.attendancetrackingsystem.dto.ComplaintDto;
import com.example.attendancetrackingsystem.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("")
    public String getAllComplaints(Model model) {
        model.addAttribute("complaints", complaintService.getAllComplaints());
        return "complaints/index";
    }

    @PostMapping("/create")
    public String createComplaint(ComplaintDto complaintDto) {
        complaintService.createComplaint(complaintDto);
        return "redirect:/complaints";
    }
}