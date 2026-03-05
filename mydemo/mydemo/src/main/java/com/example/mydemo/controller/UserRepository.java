package com.example.mydemo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mydemo.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
 Users findByEmail(String email);
}

