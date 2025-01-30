package com.example.attendancetrackingsystem.mappers;

import com.example.attendancetrackingsystem.dto.GradeDto;
import com.example.attendancetrackingsystem.models.Grade;
import org.mapstruct.Mapper;

@Mapper
public interface GradeMapper {
    GradeDto toDto(Grade grade);
    Grade toEntity(GradeDto gradeDto);
}
