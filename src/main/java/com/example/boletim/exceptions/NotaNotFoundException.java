package com.example.boletim.exceptions;

public class NotaNotFoundException extends RuntimeException{
    public NotaNotFoundException(String message) {
        super(message);
    }
}
