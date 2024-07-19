package com.powerpuffsquirrels.noveleaf.service.imp;


import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import com.powerpuffsquirrels.noveleaf.service.IHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountService implements IHash {
    private UserAccountRepository userAccountRepository;

    @Autowired
    public CreateAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    public boolean createAccount(String username, String password) {
        UserAccount bojangles = userAccountRepository.findByUsername(username);
        if(userAccountRepository.findByUsername(username) != null) {
            return false;
        } else {
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setHash(IHash.hash(password));
            userAccountRepository.save(userAccount);
            return true;
        }
    }
}
