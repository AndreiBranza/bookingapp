package com.braziigemeni.bookingapp;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.braziigemeni.bookingapp.model.User;
import com.braziigemeni.bookingapp.repository.UserRepository;
import com.braziigemeni.bookingapp.service.UserService;
import com.braziigemeni.bookingapp.util.JwtTokenProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class BookingappApplication {

	@Autowired private UserRepository userRepository;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private JwtTokenProvider tokenProvider;

	public static void main(String[] args) {
		SpringApplication.run(BookingappApplication.class, args);
	}

	@PostConstruct
	public void testDatabaseConnection() {
		try {
			log.info("Testing database connection...");
			UserService userService = new UserService(userRepository, passwordEncoder, tokenProvider);

			User testUser = new User();
			testUser.setEmail("test@test.com");
			testUser.setFirstName("Test");
			testUser.setLastName("Test");
			testUser.setPassword("test");

			User saved = userService.createUser(testUser);
			userRepository.delete(saved);

			log.info("Database connection test: SUCCESS ✅");
		} catch (Exception e) {
			log.error("Database connection test: FAILED ❌", e);
			// Decizi dacă vrei să oprești aplicația în caz de eșec
			// System.exit(1);
		}
	}
}
