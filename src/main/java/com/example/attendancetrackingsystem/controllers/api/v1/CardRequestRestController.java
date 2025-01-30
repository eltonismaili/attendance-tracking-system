package com.example.attendancetrackingsystem.controllers.api.v1;

import com.example.attendancetrackingsystem.dto.CardRequestDto;
import com.example.attendancetrackingsystem.mappers.CardRequestMapper;
import com.example.attendancetrackingsystem.models.CardRequest;
import com.example.attendancetrackingsystem.service.CardRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cardrequests")
public class CardRequestRestController {

    private final CardRequestService cardRequestService;

    public CardRequestRestController(CardRequestService cardRequestService) {
        this.cardRequestService = cardRequestService;
    }

    @GetMapping
    public List<CardRequest> getAllCardRequests() {
        return cardRequestService.getAllCardRequests();
    }

    @PostMapping
    public void createCardRequest(@RequestBody CardRequestDto cardRequestDto) {
        cardRequestService.createCardRequest(cardRequestDto);
    }
}
