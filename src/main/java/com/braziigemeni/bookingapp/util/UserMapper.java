package com.braziigemeni.bookingapp.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.braziigemeni.bookingapp.dto.CreateUserDTO;
import com.braziigemeni.bookingapp.dto.UserDTO;
import com.braziigemeni.bookingapp.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(CreateUserDTO createUserDTO);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO userDTO);
}
