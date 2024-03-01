package com.satria.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satria.theater.dto.request.AuthRequest;
import com.satria.theater.dto.request.CreateUserRequest;
import com.satria.theater.service.UserService;
import com.satria.theater.utils.JwtService;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;
    
    @PostMapping("/auth/login")
    public ResponseEntity<Object> authLogin(@RequestBody AuthRequest authRequest) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsernameEmail(), authRequest.getPassword())
        );

        if (auth.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsernameEmail());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else 
            return new ResponseEntity<>("Invalid user request.", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return new ResponseEntity<>("User created.", HttpStatus.OK);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Object> dashboard() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
