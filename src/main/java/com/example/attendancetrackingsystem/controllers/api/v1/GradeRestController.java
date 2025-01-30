package com.example.attendancetrackingsystem.controllers.api.v1;

import com.example.attendancetrackingsystem.dto.GradeDto;
import com.example.attendancetrackingsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/grades")
public class GradeRestController {

    private final GradeService gradeService;

    @Autowired
    public GradeRestController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/add")
    public ResponseEntity<GradeDto> addGrade(@RequestBody GradeDto gradeDto) {
        GradeDto newGrade = gradeService.addGrade(gradeDto);
        return ResponseEntity.ok(newGrade);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<GradeDto>> getGradesByStudentId(@PathVariable Long studentId) {
        List<GradeDto> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<String> deleteGrade(@PathVariable Long gradeId) {
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok("Grade deleted successfully.");
    }
}