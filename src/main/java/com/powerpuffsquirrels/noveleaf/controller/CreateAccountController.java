package com.powerpuffsquirrels.noveleaf.controller;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import com.powerpuffsquirrels.noveleaf.service.imp.CreateAccountService;
import com.powerpuffsquirrels.noveleaf.service.imp.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/create-account")
public class CreateAccountController {
    private final CreateAccountService createService;
    @Autowired
    public CreateAccountController(CreateAccountService createAccountService) {
        this.createService = createAccountService;
    }

    @GetMapping("/create-account")
    public String createAccountForm() {
        return "createaccount";
    }

    @PostMapping("/create-account")
    public String createUser(@RequestParam String username, @RequestParam String password, Model model){
        if(createService.createAccount(username,password)) return "redirect:/login";
        model.addAttribute("error", String.format("Account creation failed, %s is taken", username));
        return "createaccount";
    }

    
}
