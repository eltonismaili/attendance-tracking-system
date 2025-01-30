package com.example.attendancetrackingsystem.mappers.impls;


import com.example.attendancetrackingsystem.dto.ComplaintDto;
import com.example.attendancetrackingsystem.mappers.ComplaintMapper;
import com.example.attendancetrackingsystem.models.Complaint;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
public class ComplaintMapperImpl implements ComplaintMapper {

    @Override
    public ComplaintDto toDto(Complaint complaint) {
        ComplaintDto dto = new ComplaintDto();
        dto.setComplaintDescription(complaint.getComplaintDescription());
        dto.setStatus(complaint.getStatus());
        dto.setSubmissionDate(complaint.getSubmissionDate());
        return dto;
    }

    @Override
    public Complaint toEntity(ComplaintDto complaintDto) {
        Complaint entity = new Complaint();
        entity.setComplaintDescription(complaintDto.getComplaintDescription());
        entity.setStatus(complaintDto.getStatus());
        entity.setSubmissionDate(complaintDto.getSubmissionDate());
        return entity;
    }
}