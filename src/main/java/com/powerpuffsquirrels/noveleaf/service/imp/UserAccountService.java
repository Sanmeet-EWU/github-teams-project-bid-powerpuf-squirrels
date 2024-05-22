package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.repository.UserAccountRepository;
import com.powerpuffsquirrels.noveleaf.service.IUserAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;

import java.util.List;

@Service
public class UserAccountService implements IUserAccountService {

    private final UserAccountRepository userRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userRepository){
        this.userRepository = userRepository;
    }

    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hash (String password){
        return encoder.encode(password);
    }

    private UserDto UserAccountToDto(UserAccount user){
        return UserDto.builder()
                .UserID(user.getUserID())
                .username(user.getUsername())
                .build();
    }

    public UserDto validateLogin(String username, String password){
        UserAccount user = userRepository.findByUsername(username);
        if(user != null && checkPassword(password, user.getHash())){
            return UserAccountToDto(user);
        }
        return null;
    }

    public boolean LoggedIn(HttpSession Session){
        if(Session.getAttribute("user") == null) return false;
        return true;
    }

    private boolean checkPassword(String password, String storedHash){
        return BCrypt.checkpw(password, storedHash);
    }
}
