package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.controller.CreateAccount;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public CreateAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    public boolean createAccount(String username, String hash) {
        if(userAccountRepository.findByUsername(username) != null) {
            System.out.println("username already exists");
            return false;
        } else {
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setHash(hash);
            userAccountRepository.save(userAccount);
            return true;
        }
    }
}
