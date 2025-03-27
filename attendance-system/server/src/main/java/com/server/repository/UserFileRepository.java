package com.server.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.exception.UserNotFoundException;
import com.server.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserFileRepository {
    @Value("${file.path}")
    private String filePath;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<User> getAllUsers() {
        File file = new File(filePath);
        if (!file.exists()) return new ArrayList<>();

        try {
            return objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading users from file", e);
        }
    }

    public void saveAllUsers(List<User> users) {
        try {
            objectMapper.writeValue(new File(filePath), users);
        } catch (IOException e) {
            throw new RuntimeException("Error saving users to file", e);
        }
    }

    public User save(User user) {
        List<User> users = getAllUsers();
        users.removeIf(u -> u.getUserName().equals(user.getUserName()));
        users.add(user);
        saveAllUsers(users);
        return user;
    }

    public User findByUserName(String username) {
        return getAllUsers().stream()
                .filter(user -> user.getUserName().equals(username))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }
}

