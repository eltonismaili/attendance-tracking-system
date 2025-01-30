package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.LectureDto;
import com.example.attendancetrackingsystem.mappers.LectureMapper;
import com.example.attendancetrackingsystem.models.Lecture;
import com.example.attendancetrackingsystem.repositories.LectureRepository;
import com.example.attendancetrackingsystem.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureMapper lectureMapper) {
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
    }

    @Override
    public List<LectureDto> getAllLectures() {
        return lectureRepository.findAll()
                .stream()
                .map(lectureMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LectureDto getLectureById(Long id) {
        return lectureRepository.findById(id)
                .map(lectureMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Lecture not found!"));
    }

    @Override
    public LectureDto addLecture(LectureDto lectureDto) {
        Lecture lecture = lectureMapper.toEntity(lectureDto);
        Lecture savedLecture = lectureRepository.save(lecture);
        return lectureMapper.toDto(savedLecture);
    }

    @Override
    public LectureDto updateLecture(Long id, LectureDto lectureDto) {
        if (!lectureRepository.existsById(id)) {
            throw new RuntimeException("Lecture not found!");
        }
        Lecture lecture = lectureMapper.toEntity(lectureDto);
        lecture.setId(id);
        Lecture updatedLecture = lectureRepository.save(lecture);
        return lectureMapper.toDto(updatedLecture);
    }

    @Override
    public void deleteLecture(Long id) {
        if (!lectureRepository.existsById(id)) {
            throw new RuntimeException("Lecture not found!");
        }
        lectureRepository.deleteById(id);
    }
}
