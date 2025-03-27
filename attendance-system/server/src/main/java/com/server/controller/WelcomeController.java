package com.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    //This endpoint returns a welcome message
    // and can be used to check if the incoming request is authenticated with a valid JWT token.

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to attendance System!";
    }
}