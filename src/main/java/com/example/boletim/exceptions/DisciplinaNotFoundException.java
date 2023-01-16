package com.example.boletim.exceptions;

public class DisciplinaNotFoundException extends RuntimeException{
    public DisciplinaNotFoundException(String message) {
        super(message);
    }
}
