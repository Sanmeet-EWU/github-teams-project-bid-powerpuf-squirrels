package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.controller.CreateAccount;
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
    public CreateAccount createAccount(String username, String password) {
        return null;
    }

    /*
    build soemthing that will build ther create account entity. the object such match all the columns to a table.
    the new account is an object, a useraccount object.
    take controller, foreard that repo to this class. send back success if the username wasnt taken
     */






}
