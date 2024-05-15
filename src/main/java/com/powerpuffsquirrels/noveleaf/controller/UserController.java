package com.powerpuffsquirrels.noveleaf.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserController {
    private String username;
    private String passwordHash;

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.passwordHash = encoder.encode(password);
    }
}
