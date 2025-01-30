package com.example.attendancetrackingsystem.mappers;

import com.example.attendancetrackingsystem.dto.LectureDto;
import com.example.attendancetrackingsystem.models.Lecture;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LectureMapper {
    LectureDto toDto(Lecture lecture);
    Lecture toEntity(LectureDto lectureDto);

}
