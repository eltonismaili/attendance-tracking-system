package com.example.attendancetrackingsystem.mappers;


import com.example.attendancetrackingsystem.dto.AttendanceDto;
import com.example.attendancetrackingsystem.models.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "student.firstName", target = "studentName")
    @Mapping(source = "session.id", target = "sessionId")
    @Mapping(source = "session.name", target = "sessionName")
    AttendanceDto toDto(Attendance attendance);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "sessionId", target = "session.id")
    Attendance toEntity(AttendanceDto attendanceDto);
}