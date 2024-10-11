package com.example.tacocloud.service.impl;

import com.example.tacocloud.model.User;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.example.tacocloud.service.UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user
     * @param user {@link User}
     * @return {@link User}
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
