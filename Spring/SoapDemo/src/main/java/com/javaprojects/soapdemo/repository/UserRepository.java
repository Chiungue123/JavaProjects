package com.javaprojects.soapdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaprojects.soapdemo.jpa.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User> findByUsernameIgnoreCase(String username);
}