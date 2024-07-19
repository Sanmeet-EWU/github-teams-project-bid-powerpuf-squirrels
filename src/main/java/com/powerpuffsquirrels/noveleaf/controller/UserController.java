package com.powerpuffsquirrels.noveleaf.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserController {
    private final String username;
    private final String passwordHash;

    public UserController(String passwordHash) {
        this.username =
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

}
