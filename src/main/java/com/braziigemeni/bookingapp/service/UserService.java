package com.braziigemeni.bookingapp.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.braziigemeni.bookingapp.dto.ChangePasswordDTO;
import com.braziigemeni.bookingapp.dto.CreateUserDTO;
import com.braziigemeni.bookingapp.dto.UserDTO;
import com.braziigemeni.bookingapp.exception.InvalidPasswordException;
import com.braziigemeni.bookingapp.exception.UserNotFoundException;
import com.braziigemeni.bookingapp.model.User;
import com.braziigemeni.bookingapp.model.UserRole;
import com.braziigemeni.bookingapp.repository.UserRepository;
import com.braziigemeni.bookingapp.util.JwtTokenProvider;
import com.braziigemeni.bookingapp.util.UserMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    private final UserMapper userMapper;  // vom folosi mapstruct

    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userMapper.toEntity(createUserDTO);
        user.setPassword(passwordEncoder.encode(createUserDTO.password()));
        return userMapper.toDto(userRepository.save(user));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(userMapper::toDto)
            .toList();
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::toDto)
            .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public UserDTO updateUserRole(Long userId, UserRole newRole) {
        return userRepository.findById(userId)
            .map(user -> {
                user.setRole(newRole);
                return userMapper.toDto(userRepository.save(user));
            })
            .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    // această metodă nu returnează DTO pentru că e doar acțiune
    public void changePassword(Long userId, ChangePasswordDTO changePasswordDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(changePasswordDTO.oldPassword(),
            user.getPassword())) {
            throw new InvalidPasswordException("Invalid old password");
        }

        user.setPassword(passwordEncoder.encode(changePasswordDTO.newPassword()));
        userRepository.save(user);
    }

}