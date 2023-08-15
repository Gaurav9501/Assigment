package com.ExceptionHandling;

public class CustomException extends RuntimeException {
    private final String message;
    private final ExceptionType exceptionType;

    public CustomException(String message, ExceptionType exceptionType) {
        this.message = message;
        this.exceptionType = exceptionType;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }
}

