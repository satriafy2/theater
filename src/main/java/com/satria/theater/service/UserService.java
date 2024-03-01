package com.satria.theater.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.satria.theater.dto.request.CreateUserRequest;
import com.satria.theater.entity.User;

public interface UserService {
    User loadByUsernameOrEmail(String identifier);
    void createUser(CreateUserRequest userRequest);
}
