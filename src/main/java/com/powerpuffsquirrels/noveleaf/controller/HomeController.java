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

        /*
        If there are any pages that should only be displayed if the User is logged in, a simple check can be implemented:

        if ((UserDto) session.getAttribute("user") == null) {
            return "login";
        }
         */


        /*
        Reeds random, scatterbrained thoughts not worthy of going on the kanban board:

        With extra time, build a list of books that are currently trending in read lists and want to read lists.

        Would be a simple query to the database to pull all books that have been added to a read list or want to
        read list in the last week. Then simply make some call using JPA that would be the equivalent to:

        SELECT isbn, count(user_id) as count
        FROM read_shelf WHERE date_added > (current_date - 7)
        GROUP BY isbn
        ORDER BY count
        DESC LIMIT 7;

        This would be an easy way to fill out the home page, so it doesn't look so empty.

        Also in general, I will plan on turning the list of books I have going on in many of the pages, into more of
        a card style layout. This will make it look more modern and clean. Just need to sort out the thymeleaf iteration
        for it. Probably something along the lines of a list within a list, so that you get rows of 5 or so books before
        moving to the next row.
         */



        return "index";// index.html
    }
}
