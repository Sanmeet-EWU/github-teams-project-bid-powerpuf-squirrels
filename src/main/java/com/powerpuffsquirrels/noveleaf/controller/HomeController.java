package com.powerpuffsquirrels.noveleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // you want to simply bind this to the root. This is equivalent to http://localhost:10480/
        public String home()
    {
        return "index";// index.html

    }
}
