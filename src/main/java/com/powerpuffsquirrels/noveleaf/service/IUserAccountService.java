package com.powerpuffsquirrels.noveleaf.service;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public interface IUserAccountService {
    //UserDto FindUser(String username, String password);
    public UserDto validateLogin(String username, String password);
    public boolean LoggedIn(HttpSession session);
}