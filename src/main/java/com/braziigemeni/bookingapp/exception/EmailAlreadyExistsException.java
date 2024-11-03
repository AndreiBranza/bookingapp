package com.braziigemeni.bookingapp.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String emailAlreadyExists) {
        super(emailAlreadyExists);
    }
}
