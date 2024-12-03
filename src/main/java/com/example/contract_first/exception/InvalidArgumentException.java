package com.example.contract_first.exception;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(String message){
        super("Invalid request: " + message);
    }
}
