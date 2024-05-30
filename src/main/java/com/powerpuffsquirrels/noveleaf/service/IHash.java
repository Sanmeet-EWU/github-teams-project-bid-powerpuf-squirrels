package com.powerpuffsquirrels.noveleaf.service;

import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface IHash {

    static PasswordEncoder encoder = new BCryptPasswordEncoder();

    static String hash (String password){
        return encoder.encode(password);
    }



}
