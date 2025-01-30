package com.example.attendancetrackingsystem.mappers;

import com.example.attendancetrackingsystem.dto.TeacherDto;
import com.example.attendancetrackingsystem.models.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(TeacherDto teacherDto);
    TeacherDto toDto(Teacher teacher);
}