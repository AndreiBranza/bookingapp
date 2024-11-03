package com.braziigemeni.bookingapp.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String invalidCredentials) {
        super(invalidCredentials);
    }
}
