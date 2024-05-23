/*
    This will handle all the UI stuff
    Then we store that string in database to back end
    we're going to use MD5
    database management
    Creates User Database, User Object, and Hashed Password for storing

*/
//Reed: Looks like we're using BCrypt, not MD5?

package com.powerpuffsquirrels.noveleaf.controller;
import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.service.IUserAccountService;
import com.powerpuffsquirrels.noveleaf.service.imp.UserAccountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/login")
public class LoginController {

    private final IUserAccountService userService;
    @Autowired
    public LoginController (UserAccountService userService){this.userService = userService;}

/*    @GetMapping( "/")
    public String loginHomepage(HttpSession session) {
        if(userService.LoggedIn(session)) return "index";
        return "login";
    }*/

    @GetMapping("/login")
    public String login(HttpSession session) {
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin( @RequestParam String username, @RequestParam String password,
            HttpSession session, Model model) {
        UserDto user = userService.validateLogin(username, password);

        if(user == null) {
            model.addAttribute("error","Login Failed, Account info not recognised.");
            return "login";
        }

        session.setAttribute("user", user);
        model.addAttribute("user", user);
        return "login-success";
    }
}

