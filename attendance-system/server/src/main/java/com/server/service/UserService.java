package com.server.service;

import com.server.exception.UserNotFoundException;
import com.server.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserService(AuthenticationManager authenticationManager, JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String verify(User user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword())
        );
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(user);
        }
        throw new UserNotFoundException("Invalid credentials");
    }

}