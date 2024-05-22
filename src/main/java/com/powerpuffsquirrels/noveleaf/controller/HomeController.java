package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // you want to simply bind this to the root. This is equivalent to http://localhost:10480/
        public String home(Model model, HttpSession session)
    {
        //This will allow us to display different elements based on whether the user is logged in
        //This should be added to every controller!
        //Must ensure (Model model, HttpSession session) are passed in as parameters!!
        model.addAttribute("userAccount", (UserDto) session.getAttribute("user"));
        

        return "index";// index.html

    }
}
