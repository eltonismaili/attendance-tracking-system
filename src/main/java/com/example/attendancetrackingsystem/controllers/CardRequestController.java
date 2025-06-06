package com.example.attendancetrackingsystem.controllers;

import com.example.attendancetrackingsystem.dto.CardRequestDto;
import com.example.attendancetrackingsystem.service.CardRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class CardRequestController {
    private final CardRequestService cardRequestService;

    public CardRequestController(CardRequestService cardRequestService) {
        this.cardRequestService = cardRequestService;
    }

    @GetMapping("card")
    public String getAllCardRequests(Model model) {
        model.addAttribute("cardRequests", cardRequestService.getAllCardRequests());
        return "card/index";
    }

    @PostMapping("card/add")
    public String createCardRequest(CardRequestDto cardRequestDto) {
        cardRequestService.createCardRequest(cardRequestDto);
        return "redirect:/card";
    }
}


