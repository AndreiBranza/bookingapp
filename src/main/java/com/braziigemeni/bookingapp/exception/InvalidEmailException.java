package com.braziigemeni.bookingapp.exception;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String invalidCredentials) {
        super(invalidCredentials);
    }
}
