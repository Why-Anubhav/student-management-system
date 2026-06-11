package com.example.lms.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super("Kuch toh gadbad hai");
    }
}