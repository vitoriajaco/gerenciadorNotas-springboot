package com.example.boletim.exceptions;

public class AlunoNotFoundException extends RuntimeException{

    public AlunoNotFoundException(String message){
        super(message);
    }
}
