package com.example.attendancetrackingsystem.exceptions;

public class StudentAlreadyExists extends RuntimeException {
    public StudentAlreadyExists(String message) {
        super(message);
    }
}
