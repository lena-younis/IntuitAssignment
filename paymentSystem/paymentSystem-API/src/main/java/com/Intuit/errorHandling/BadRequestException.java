package com.Intuit.errorHandling;

public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
