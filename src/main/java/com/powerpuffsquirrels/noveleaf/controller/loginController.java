/*
    This will handle all the UI stuff
    Then we store that string in database to back end
    we're going to use MD5
    database management
    Creates User Database, User Object, and Hashed Password for storing

*/
//Reed: Looks like we're using BCrypt, not MD5?

package com.powerpuffsquirrels.noveleaf.controller;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;

import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String userPass) {
        return encoder.encode(userPass);
    }

    public static boolean comparePass(String inputPass, String hashedPass) {
        return encoder.matches(inputPass, hashedPass);
    }
    @GetMapping("/login")
    public static void main(String[] args) {
        //nothing that was in here was correct. This needs to be getting information from the login.html file, not
        //scanners
    }
//<<<<<<< Updated upstream

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        // hash the pass
        String hashedPass = hashPassword(password);

        //pull the record for the user name from the user_id field from the user_account table using

        return "redirect:/";  // Redirect to a different page after login
    }

}

