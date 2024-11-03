package com.braziigemeni.bookingapp.dto;

public record ChangePasswordDTO(
    String oldPassword,
    String newPassword
) {}
