package com.braziigemeni.bookingapp.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.braziigemeni.bookingapp.model.User;
import com.braziigemeni.bookingapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticateUser(String email, String rawPassword) {
        return userRepository.findByEmail(email)
            .map(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
            .orElse(false);
    }

    // Metodă utilă pentru găsirea user-ului după email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}