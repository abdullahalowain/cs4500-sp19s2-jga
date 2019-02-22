package com.example.cs4500sp19s2jga.services;

import java.util.List;

import com.example.cs4500sp19s2jga.models.User;

public interface UserService {
    User createUser(User user);
    List<User> findAllUsers();
}