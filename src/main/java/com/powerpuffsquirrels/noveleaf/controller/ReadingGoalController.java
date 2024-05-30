package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadingGoalService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReadingGoalController {
    private ReadingGoalService goalService;

    @Autowired
    public ReadingGoalController (ReadingGoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/ReadingGoals")
    public String DisplayReadingGoals(HttpSession session, Model model){
        UserDto user = (UserDto) session.getAttribute("user");
        model.addAttribute("user");

        List<ReadingGoal> goalList = goalService.GetGoalsByUserID(user.getUserID());
        model.addAttribute("goalList", goalList);

        return ("reading-goals");
    }





}
