package com.example.attendancetrackingsystem.service;

import com.example.attendancetrackingsystem.dto.LectureDto;

import java.util.List;

public interface LectureService {
    List<LectureDto> getAllLectures();
    LectureDto getLectureById(Long id);
    LectureDto addLecture(LectureDto lectureDto);
    LectureDto updateLecture(Long id, LectureDto lectureDto);
    void deleteLecture(Long id);
}
