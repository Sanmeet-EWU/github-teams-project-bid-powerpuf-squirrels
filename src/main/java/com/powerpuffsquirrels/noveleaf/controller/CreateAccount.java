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
    private final UserAccountRepository userAccountRepository;
    @Autowired
    public CreateAccount(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping
    public String createAccountForm() {
        return "create-account";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserAccount userAccount){
        userAccountRepository.save(userAccount);
        return  "redirect:/login";
    }

    
}
