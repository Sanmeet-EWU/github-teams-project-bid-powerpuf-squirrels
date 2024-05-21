package com.powerpuffsquirrels.noveleaf.service;

import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository){
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount validateLogin(String username, String password){
        UserAccount user = userAccountRepository.findByUsername(username);
        if(user != null && checkPassword(password, user.getHash())){
            return user;
        }
        return null;
    }

    private boolean checkPassword(String password, String storedHash){
        return BCrypt.checkpw(password, storedHash);
    }
}
