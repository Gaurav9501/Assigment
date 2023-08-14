package com.ExceptionHandling;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
        super(message);
    }
}
