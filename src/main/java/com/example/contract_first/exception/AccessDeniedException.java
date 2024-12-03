package com.example.contract_first.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super("Access denied: " + message);
    }
}
