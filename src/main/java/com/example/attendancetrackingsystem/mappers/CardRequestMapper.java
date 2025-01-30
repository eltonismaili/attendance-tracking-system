package com.example.attendancetrackingsystem.mappers;

import com.example.attendancetrackingsystem.dto.CardRequestDto;
import com.example.attendancetrackingsystem.models.CardRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CardRequestMapper {
    CardRequestDto toDto(CardRequest cardRequest);
    CardRequest toEntity(CardRequestDto cardRequestDto);
}