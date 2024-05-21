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


/*    @Override
    public UserDto FindUser(String username, String password) {

        UserAccount exampleUser = UserAccount.builder().username(username).build();
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("userID").withIgnorePaths("hash").withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact());
        Example<UserAccount> searchExample = Example.of(exampleUser, matcher);

        List<UserAccount> users = userRepository.findAll(searchExample);

        if (users.isEmpty() || !encoder.matches(password, users.get(0).getHash())) return null;

        UserAccount user = users.get(0);//this will only have one item if usernames are unique
        return UserAccountToDto(user);
    }*/

    //redundant with david's implementation

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


    //this feels like a clumsy implementation to me, I certainly don't want every controller to have to call instantiate this class
    //so this method will have to find a new home later, or a new implementation
    public boolean LoggedIn(HttpSession Session){
        if(Session.getAttribute("user") == null) return false;
        return true;
    }

    private boolean checkPassword(String password, String storedHash){
        return BCrypt.checkpw(password, storedHash);
    }
}
