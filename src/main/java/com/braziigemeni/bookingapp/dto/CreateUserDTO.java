package com.braziigemeni.bookingapp.dto;

import com.braziigemeni.bookingapp.model.UserRole;

public record CreateUserDTO(
    String email,
    String password,
    String name,
    String phone,
    UserRole role
) {}
