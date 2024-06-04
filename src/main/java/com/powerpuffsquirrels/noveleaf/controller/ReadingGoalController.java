package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.ReadingGoal;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadingGoalService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ReadingGoalController {
    private ReadingGoalService goalService;

    @Autowired
    public ReadingGoalController(ReadingGoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/ReadingGoals")
    public String DisplayReadingGoals(HttpSession session, Model model){
        UserDto user = (UserDto) session.getAttribute("user");
        model.addAttribute("userAccount", user);

        List<ReadingGoal> goalList = goalService.GetGoalsByUserID(user.getUserID());
        goalList = goalService.checkGoals(goalList);
        model.addAttribute("goalList", goalList);
        return ("reading-goals");
    }

    @PostMapping("/ReadingGoals-delete")
    public String DeleteGoal(@RequestParam int goalId){
        goalService.DeleteGoal(goalId);
        return "redirect:/ReadingGoals";
    }

    @PostMapping("/ReadingGoals")
    public String AddReadingGoal(@RequestParam int readingGoal, @RequestParam Date deadline, HttpSession session, Model model){

        List<ReadingGoal> goalList = goalService.AddGoal(readingGoal,deadline,(UserDto)session.getAttribute("user"));
        model.addAttribute("goalList", goalService.checkGoals(goalList));
       return ("reading-goals");
    }




}
