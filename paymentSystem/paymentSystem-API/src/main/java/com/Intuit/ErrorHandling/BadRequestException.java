package com.Intuit.ErrorHandling;

public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
