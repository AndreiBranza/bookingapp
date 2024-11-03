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

	public static void main(String[] args) {
		SpringApplication.run(BookingappApplication.class, args);
	}
}
