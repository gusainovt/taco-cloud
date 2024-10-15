package com.example.tacocloud.service;

import com.example.tacocloud.model.User;

public interface UserService {
    User createUser(User user);
    User getUserByUsername(String username);
}
