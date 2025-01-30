package com.example.attendancetrackingsystem.mappers;

import com.example.attendancetrackingsystem.dto.ComplaintDto;
import com.example.attendancetrackingsystem.models.Complaint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    ComplaintDto toDto(Complaint complaint);
    Complaint toEntity(ComplaintDto complaintDto);
}
