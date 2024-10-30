package com.braziigemeni.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.braziigemeni.bookingapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
