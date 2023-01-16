package com.example.boletim.exceptions;

public class AlunoSameIdException extends RuntimeException{
    public AlunoSameIdException(String message) {
        super(message);
    }
}
