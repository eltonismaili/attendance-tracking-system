package com.example.attendancetrackingsystem.mappers.impls;

import com.example.attendancetrackingsystem.dto.LectureDto;
import com.example.attendancetrackingsystem.mappers.LectureMapper;
import com.example.attendancetrackingsystem.models.Lecture;
import org.springframework.context.annotation.Primary;

@Primary
public class LectureImpl implements LectureMapper {
    @Override
    public LectureDto toDto(Lecture lecture) {
        if (lecture == null) return null;

        LectureDto dto = new LectureDto();
        dto.setId(lecture.getId());
        dto.setTitle(lecture.getTitle());
        dto.setDescription(lecture.getDescription());
        dto.setLectureUrl(lecture.getLectureUrl());

        return dto;
    }

    @Override
    public Lecture toEntity(LectureDto dto) {
        if (dto == null) return null;

        Lecture lecture = new Lecture();
        lecture.setId(dto.getId());
        lecture.setTitle(dto.getTitle());
        lecture.setDescription(dto.getDescription());
        lecture.setLectureUrl(dto.getLectureUrl());
         // Shtohet fileUrl
        return lecture;
    }
}
