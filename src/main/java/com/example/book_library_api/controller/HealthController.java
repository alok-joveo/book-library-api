package com.example.book_library_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    // Root endpoint
    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
                "success", "true",
                "message", "Book Library API is running"
        );
    }

    // Health check endpoint
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "success", "true",
                "message", "Server is up and running",
                "service", "book-library-api"
        );
    }
}