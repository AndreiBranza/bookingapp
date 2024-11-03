package com.braziigemeni.bookingapp.dto;

import com.braziigemeni.bookingapp.model.UserRole;

public record UserDTO(
    Long id,
    String email,
    String name,
    String phone,
    UserRole role
) {}
