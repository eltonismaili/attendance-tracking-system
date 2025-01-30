package com.example.attendancetrackingsystem.service.impls;

import com.example.attendancetrackingsystem.dto.CardRequestDto;
import com.example.attendancetrackingsystem.mappers.CardRequestMapper;
import com.example.attendancetrackingsystem.models.CardRequest;
import com.example.attendancetrackingsystem.service.CardRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.attendancetrackingsystem.repositories.CardRequestRepository;
@Service
public class CardRequestServiceImpl implements CardRequestService {

    private final CardRequestRepository cardRequestRepository;

    public CardRequestServiceImpl(CardRequestRepository cardRequestRepository) {
        this.cardRequestRepository = cardRequestRepository;
    }

    @Override
    public void createCardRequest(CardRequestDto cardRequestDto) {
        CardRequest cardRequest = new CardRequest();
        cardRequest.setStudentName(cardRequestDto.getStudentName());
        cardRequest.setStudentId(cardRequestDto.getStudentId());
        cardRequest.setRequestDate(cardRequestDto.getRequestDate());
        cardRequest.setStatus(cardRequestDto.getStatus());
        cardRequestRepository.save(cardRequest);
    }

    @Override
    public List<CardRequest> getAllCardRequests() {
        return cardRequestRepository.findAll();
    }
}
