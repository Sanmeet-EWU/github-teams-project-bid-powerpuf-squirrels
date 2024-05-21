package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/create-account")
public class CreateAccount {
    @Autowired
    private UserAccountRepository userRepo;

    @GetMapping
    public String createAccountForm() {
        return "create-account-form";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserAccount userAccount){
        // save to database here
        return  "redirect:/login";
    }





}
