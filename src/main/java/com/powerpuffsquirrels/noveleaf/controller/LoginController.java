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
import com.powerpuffsquirrels.noveleaf.Service.IUserService;
import com.powerpuffsquirrels.noveleaf.Service.imp.UserService;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/")
public class LoginController {


    private final IUserService userService; //looser coupling, now any IUserService can be used
    @Autowired
    public LoginController (UserService userService){this.userService = userService;}




   /* public static boolean comparePass(String inputPass, String hashedPass) {
        return encoder.matches(inputPass, hashedPass);
    }*/
    /*@GetMapping("/login")
    public static void main(String[] args) {//this does nothing, it doesn't map to the html page
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: ");
        String userPass = scanner.nextLine();
        String hashedPass = hashPassword(userPass);
        System.out.println("Hashed password: " + hashedPass);

        System.out.println("Enter password again: ");
        String inputPass = scanner.nextLine();
        boolean matches = comparePass(inputPass, hashedPass);
        if (matches) {
            System.out.println("Good job logging in");
        } else {
            System.out.println("Wrong password try again");
        }

    }*/

    @GetMapping("/")
    public String login() {
        return "login"; //
    }

    @PostMapping("/login")
    public String validateLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session, Model model) {

        UserAccount user = userService.FindUser(username, password);

        if(user == null) {
            model.addAttribute("error","Login Failed, Account info not recognised.");
            return "login";
        }
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        return "successtest"; //TODO: replace with home page
    }

}