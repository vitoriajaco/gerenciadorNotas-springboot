package com.example.boletim.exceptions;

public class DisciplinaSameIdException extends RuntimeException{
    public DisciplinaSameIdException(String message) {
        super(message);
    }
}
