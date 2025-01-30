package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.TeacherDto;
import com.example.attendancetrackingsystem.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherById(Long id);
    TeacherDto createTeacher(TeacherDto teacherDto);
    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
    void deleteTeacher(Long id);

}
