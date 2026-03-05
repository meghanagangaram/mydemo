package com.example.mydemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mydemo.Users;


@RestController
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    UserRepository userRepo;


    @GetMapping("/users")
public List<Users> getAllUsers()
{
    return this.userRepo.findAll();
}
@PostMapping("/register")
public ResponseEntity<String> register (@RequestBody Users user){
    Users u=this.userRepo.findByEmail(user.getEmail());
    if(u!=null){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
    }
    this.userRepo.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("user registered successfully");
}
    
    
}
