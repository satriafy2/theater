package com.satria.theater.service;

import com.satria.theater.entity.User;

public interface UserService {
    User loadByUsernameOrEmail(String identifier);
    void createUser(User user);
}
