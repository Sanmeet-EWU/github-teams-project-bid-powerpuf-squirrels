package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserPreferencesDTO;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.service.imp.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserPreferencesController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping("/preferences")
    public String getUserPreferences(@PathVariable("user_id") Integer userId, Model model) {
        List<Preference> preferences = userPreferenceService.getUserPreferences(userId);
        model.addAttribute("preferences", preferences);
        model.addAttribute("userId", userId);
        model.addAttribute("preferencesDTO", new UserPreferencesDTO());
        return "preferences"; // This is the name of the Thymeleaf template (preferences.html)
    }

    @PostMapping("/{user_id}")
    public String saveUserPreferences(@PathVariable("user_id") Integer userId,
                                      @ModelAttribute UserPreferencesDTO preferencesDTO, Model model) {
        userPreferenceService.saveUserPreferences(userId, preferencesDTO.getGenres(), preferencesDTO.getBookTypes(), preferencesDTO.getValue());
        return "redirect:/preferences/" + userId; // Redirect to the user's preferences page
    }

}



