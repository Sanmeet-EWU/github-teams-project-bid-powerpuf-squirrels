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

    private final IUserAccountService userService; //looser coupling, now any IUserService can be used
    @Autowired
    public LoginController (UserAccountService userService){this.userService = userService;}
    @GetMapping("/")
    public String login(HttpSession session) {
        if(userService.LoggedIn(session)) return "index"; //so that login page is the first page on visiting website
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session, Model model) {


        //UserDto user = userService.FindUser(username, password);
        UserDto user = userService.validateLogin(username, password);

        if(user == null) {
            model.addAttribute("error","Login Failed, Account info not recognised.");
            return "login";
        }
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        //return "redirect:/success";
        return "index";
    }











    /*
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String userPass) {
        return encoder.encode(userPass);
    }

    public static boolean comparePass(String inputPass, String hashedPass) {
        return encoder.matches(inputPass, hashedPass);
    }
    @GetMapping("/login") // GetMapping is what runs when the user goes to the page
    public String showPage(String[] args) {
        //nothing that was in here was correct. This needs to be getting information from the login.html file, not
        //scanners

        //this is basically where any pre-processing that you need to do before getting the login data from the form
        //That being said, I can't think of anything that we would need to do before getting the login data from the form

        return "login"; //This String gets sent back to thyemleaf to tell it what page to display
    }
//<<<<<<< Updated upstream

    @PostMapping("/login") //PostMapping is what runs when the user submits the form
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        //this is what runs after they submit the form

        // hash the pass
        String hashedPass = hashPassword(password);

        //pull the record for the user name from the user_id field from the user_account table using

        return "redirect:/";  // Redirect to a different page after login
    }
*/

}

