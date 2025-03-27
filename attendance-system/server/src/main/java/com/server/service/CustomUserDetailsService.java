package com.server.service;

import com.server.CustomUserDetails;
import com.server.model.User;
import com.server.repository.UserFileRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserFileRepository userFileRepository;

    public CustomUserDetailsService(UserFileRepository userFileRepository) {
        this.userFileRepository = userFileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFileRepository.findByUserName(username);
        if(Objects.isNull(user)) {
            System.out.println("User not available");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}