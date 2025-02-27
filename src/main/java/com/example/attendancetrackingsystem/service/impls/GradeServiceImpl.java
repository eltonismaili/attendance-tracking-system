package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.GradeDto;
import com.example.attendancetrackingsystem.mappers.GradeMapper;
import com.example.attendancetrackingsystem.models.Grade;
import com.example.attendancetrackingsystem.models.Student;
import com.example.attendancetrackingsystem.repositories.GradeRepository;
import com.example.attendancetrackingsystem.repositories.StudentRepository;
import com.example.attendancetrackingsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public GradeDto addGrade(GradeDto gradeDto) {
        if (gradeDto.getDateAwarded() == null) {
            gradeDto.setDateAwarded(LocalDate.now());
        }
        Student student = studentRepository.findById(gradeDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Grade grade = gradeMapper.toEntity(gradeDto);
        grade.setStudent(student);

        Grade savedGrade = gradeRepository.save(grade);
        return gradeMapper.toDto(savedGrade);
    }
    @Override
    public List<GradeDto> getAllGrades() {
        List<Grade> grades = gradeRepository.findAll();
        return grades.stream().map(gradeMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public List<GradeDto> getGradesByStudentId(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        return grades.stream().map(gradeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}