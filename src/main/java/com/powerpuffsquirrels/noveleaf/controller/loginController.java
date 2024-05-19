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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Controller
public class loginController {
    //private static final String DB_URL = noveleafdb.ddns.net:3306;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String userPass) {
        return encoder.encode(userPass);
    }

    public static boolean comparePass(String inputPass, String hashedPass) {
        return encoder.matches(inputPass, hashedPass);
    }
    @GetMapping("/login")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String userPass = scanner.nextLine();
        String hashedPass = hashPassword(userPass);
        System.out.println("Hashed password: " + hashedPass);

        System.out.println("Enter password again: ");
        String inputPass = scanner.nextLine();
        boolean matches = comparePass(inputPass, hashedPass);
        if (matches) {
            System.out.println("Good job logging in");
        } else {
            System.out.println("Wrong password try again");
        }

    }
}