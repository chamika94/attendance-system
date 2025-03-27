package com.server.controller;

import com.server.exception.UserNotFoundException;
import com.server.model.TokenResponse;
import com.server.model.User;
import com.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //This controller is used to Handles user login by verifying credentials and returning a token if successful
    //and responds with an unauthorized status if the user is not found

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody User user) {
        try {
            String token = userService.verify(user);
            TokenResponse tokenResponse = new TokenResponse(token);
            return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new TokenResponse(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

}

