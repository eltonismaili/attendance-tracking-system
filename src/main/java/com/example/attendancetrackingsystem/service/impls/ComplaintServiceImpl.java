package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.ComplaintDto;
import com.example.attendancetrackingsystem.mappers.ComplaintMapper;
import com.example.attendancetrackingsystem.models.Complaint;
import com.example.attendancetrackingsystem.repositories.ComplaintRepository;
import com.example.attendancetrackingsystem.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ComplaintServiceImpl implements ComplaintService {

    private  final ComplaintRepository complaintRepository;
    private final ComplaintMapper complaintMapper;


    public ComplaintServiceImpl(ComplaintRepository complaintRepository, ComplaintMapper complaintMapper) {
        this.complaintRepository = complaintRepository;
        this.complaintMapper = complaintMapper;
    }

    @Override
    public ComplaintDto createComplaint(ComplaintDto complaintDTO) {
        Complaint complaint = complaintMapper.toEntity(complaintDTO);
        complaint.setSubmissionDate(LocalDate.now());
        complaint = complaintRepository.save(complaint);
        return complaintMapper.toDto(complaint);
    }

    @Override
    public List<ComplaintDto> getAllComplaints() {
        List<Complaint> complaints = complaintRepository.findAll();
        return complaints.stream()
                .map(complaintMapper::toDto)
                .collect(Collectors.toList());
    }
}
