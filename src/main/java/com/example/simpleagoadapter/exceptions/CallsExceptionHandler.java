package com.example.simpleagoadapter.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CallsExceptionHandler {

    @ExceptionHandler(CommandNotExistException.class)
    protected ResponseEntity<Object> handleCommandNotExistExp(CommandNotExistException e) {
        ShortedCommandNotExistException exception = new ShortedCommandNotExistException(e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShortedCommandNotExistException {
        private String message;
    }
}
