package com.example.attendancetrackingsystem.advices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.net.BindException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {



    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception e, Model model) {
        HttpStatus defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (e instanceof BindException || e instanceof MethodArgumentNotValidException || e instanceof IllegalArgumentException) {
            defaultStatus = HttpStatus.BAD_REQUEST;
        } else if (e instanceof EntityNotFoundException) {
            defaultStatus = HttpStatus.NOT_FOUND;
        }

        model.addAttribute("status", defaultStatus.value());
        model.addAttribute("error", defaultStatus.getReasonPhrase());
        model.addAttribute("message", e.getMessage());
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("timestamp", LocalDateTime.now());

        return new ModelAndView("error/error-page", model.asMap());
    }


}