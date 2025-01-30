package com.example.attendancetrackingsystem.mappers.impls;

import com.example.attendancetrackingsystem.dto.TeacherDto;
import com.example.attendancetrackingsystem.mappers.TeacherMapper;
import com.example.attendancetrackingsystem.models.Teacher;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component("teacherMapperImpl1")
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherDto teacherDTO = new TeacherDto();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setEmail(teacher.getEmail());
        // Map other fields similarly
        return teacherDTO;
    }

    @Override
    public Teacher toEntity(TeacherDto teacherDto) {
        if (teacherDto == null) {
            return null;
        }

        // Krijo një objekt Teacher duke përdorur konstruktorin me Long
        Teacher teacher = new Teacher(teacherDto.getId());  // Përdor constructorin që merr Long
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setEmail(teacherDto.getEmail());
        // Map other fields similarly
        return teacher;
    }

}