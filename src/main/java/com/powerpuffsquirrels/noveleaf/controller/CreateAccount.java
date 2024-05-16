package com.powerpuffsquirrels.noveleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

public class CreateAccount {

    public CreateAccount(String newUsername, String newPass) {
    }
    @GetMapping("/create account")
    public static void newUserCred() {
        System.out.println("Create username: ");
        Scanner input = new Scanner(System.in);
        String newUsername = input.nextLine();
        System.out.println("Create a new password: ");
        Scanner input2 = new Scanner(System.in);
        String newPass = input.nextLine();
        CreateAccount account1 = new CreateAccount(newUsername, newPass);
    }



}
