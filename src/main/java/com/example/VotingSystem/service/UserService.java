package com.example.VotingSystem.service;

import org.springframework.context.annotation.Lazy;

import com.example.VotingSystem.model.User;

@Lazy
public interface UserService {
    User getUserById(String id);

    User getUserByUsername(String username);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(String id);
}