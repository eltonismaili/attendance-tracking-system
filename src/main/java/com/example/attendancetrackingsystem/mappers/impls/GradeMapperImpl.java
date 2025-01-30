package com.example.attendancetrackingsystem.mappers.impls;

import com.example.attendancetrackingsystem.dto.GradeDto;
import com.example.attendancetrackingsystem.mappers.GradeMapper;
import com.example.attendancetrackingsystem.models.Grade;
import org.springframework.stereotype.Component;

@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public GradeDto toDto(Grade grade) {
        if (grade == null) {
            return null;
        }

        GradeDto gradeDTO = new GradeDto();
        gradeDTO.setId(grade.getId());
        gradeDTO.setStudentId(grade.getStudent().getId());
        gradeDTO.setCourseName(grade.getCourseName());
        gradeDTO.setGrade(grade.getGrade());
        gradeDTO.setDateAwarded(grade.getDateAwarded());

        return gradeDTO;
    }

    @Override
    public Grade toEntity(GradeDto gradeDTO) {
        if (gradeDTO == null) {
            return null;
        }

        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setCourseName(gradeDTO.getCourseName());
        grade.setGrade(gradeDTO.getGrade());
        grade.setDateAwarded(gradeDTO.getDateAwarded());

        return grade;
    }
}