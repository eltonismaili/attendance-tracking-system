package com.example.attendancetrackingsystem.mappers;

public interface BasicMapper<DTO, ENTITY> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
