package com.example.simpleagoadapter.exceptions;

public class CommandNotExistException extends RuntimeException{
    public CommandNotExistException(long id) {
        super(String.format("Call with id = %d does not exist", id));
    }
}
