package com.braziigemeni.bookingapp.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userNotFound) {
        super(userNotFound);
    }
}
