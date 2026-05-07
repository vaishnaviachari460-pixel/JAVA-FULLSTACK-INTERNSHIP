package com.example.demo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.backend.model.User;
import com.example.demo.backend.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UserRepository repository;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User existingUser = repository.findByUsername(user.getUsername());

        if (existingUser != null) {
            return "Username already exists";
        }

        repository.save(user);

        return "Registration Successful";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = repository.findByUsername(user.getUsername());

        if (existingUser == null) {
            return "User not found";
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}