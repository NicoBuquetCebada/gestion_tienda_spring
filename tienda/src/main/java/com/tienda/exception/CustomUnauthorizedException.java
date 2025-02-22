package com.tienda.exception;

public class CustomUnauthorizedException extends Exception {
    public CustomUnauthorizedException(String message) {
        super(message);
    }
}
