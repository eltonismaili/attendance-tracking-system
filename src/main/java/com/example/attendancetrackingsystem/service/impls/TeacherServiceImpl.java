package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.TeacherDto;
import com.example.attendancetrackingsystem.mappers.TeacherMapper;
import com.example.attendancetrackingsystem.models.Teacher;
import com.example.attendancetrackingsystem.repositories.TeacherRepository;
import com.example.attendancetrackingsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        if (teacherRepository.findByEmail(teacherDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Student already exists with email: " + teacherDto.getEmail());
        }
        Teacher teacher = teacherMapper.toEntity(teacherDto);
        return teacherMapper.toDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {


        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setEmail(teacherDto.getEmail());

        return teacherMapper.toDto(teacherRepository.save(teacher));
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}


