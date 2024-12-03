package com.example.contract_first.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlers {

    private static final String ERROR_STATUS = "error";

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<StatusResponse> handleBadRequestException(InvalidArgumentException e) {
        var status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, e.getMessage()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StatusResponse> handleNotFoundException(ResourceNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StatusResponse> handleAccessDeniedException(AccessDeniedException e) {
        var status = HttpStatus.FORBIDDEN;
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusResponse> handleValidationException(MethodArgumentNotValidException e) {
        var status = HttpStatus.BAD_REQUEST;
        var message = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(java.util.stream.Collectors.joining(", "));
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, "Validation failed: " + message));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StatusResponse> handleGenericException(Exception e) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, "An unexpected error occurred: " + e.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StatusResponse> handleNoSuchElementException(NoSuchElementException e) {
        var status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StatusResponse(ERROR_STATUS, "No such element found: " + e.getMessage()));
    }
}
