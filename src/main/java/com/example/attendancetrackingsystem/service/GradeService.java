package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.GradeDto;

import java.util.List;

public interface GradeService {
    GradeDto addGrade(GradeDto gradeDto);
    List<GradeDto> getGradesByStudentId(Long studentId);
    void deleteGrade(Long gradeId);

    public List<GradeDto> getAllGrades();
}