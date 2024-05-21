package com.powerpuffsquirrels.noveleaf.Service.imp;


import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.Service.IUserService;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository){this.userRepository = userRepository;}
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static String hash(String password){
        return encoder.encode(password);
    }

    @Override
    public UserAccount FindUser(String username, String password) {

        UserAccount exampleUser = UserAccount.builder().username(username).build();
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("userID").withIgnorePaths("hash").withMatcher("username", GenericPropertyMatchers.exact());
        //it is possible that this search function may not work correctly anymore due to strangeness with the entity class field names
        Example<UserAccount> searchExample = Example.of(exampleUser, matcher);

        List<UserAccount> users = userRepository.findAll(searchExample);


        if (users.isEmpty() || !encoder.matches(password, users.get(0).getHash())) return null;

        UserAccount user = users.get(0);//if this works correctly this will only have one item, *IF we implement no duplicate usernames in account creation

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getHash(),null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return user;
    }

    private UserDto UserToDto(UserAccount user){
        return UserDto.builder()
                .UserID(user.getUserID())
                .username(user.getUsername())
                .build();
    }
}
