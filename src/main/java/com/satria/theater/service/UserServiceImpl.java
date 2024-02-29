package com.satria.theater.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.satria.theater.entity.User;
import com.satria.theater.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User loadByUsernameOrEmail(String identifier) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findbyUsernameOrEmail(identifier, identifier);
        if (user.isEmpty()) throw new UsernameNotFoundException("Username not found: " + identifier);
        return user.get();
    }

    @Override
    public void createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
