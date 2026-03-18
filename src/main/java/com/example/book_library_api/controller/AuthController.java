package com.example.book_library_api.controller;

import com.example.book_library_api.dto.AuthRequest;
import com.example.book_library_api.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest request) {

        if (request.getUsername().equals("alok-joveo")
                && request.getPassword().equals("alok1234")) {

            String token = jwtUtil.generateToken(request.getUsername());

            return Map.of("token", token);
        }

        throw new RuntimeException("Invalid credentials");
    }
}