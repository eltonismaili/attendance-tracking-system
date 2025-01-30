package com.example.attendancetrackingsystem.mappers;


import com.example.attendancetrackingsystem.dto.SessionDto;
import com.example.attendancetrackingsystem.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    @Mapping(source = "teacher.id", target = "teacherId")
    SessionDto toDto(Session session);
}