package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.service.imp.UserPreferenceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserPreferencesController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping("/preferences")
    public String getPreferences(Model model, HttpSession session) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("userAccount", user);

        List<Preference> userPreferences = userPreferenceService.getPreferencesByUserId(user.getUserID());
        model.addAttribute("userId", user.getUserID());
        model.addAttribute("userPreferences", userPreferences);

        String genres = userPreferences.stream()
                .filter(pref -> "genre".equals(pref.getPrefType()))
                .map(Preference::getValue)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        model.addAttribute("genres", genres);

        return "view-preferences";
    }

    @PostMapping("/update-preferences")
    public String updatePreferences(@RequestParam("genres") String genres,
                                    HttpSession session,
                                    Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        int userId = user.getUserID();

        List<String> genreList = Arrays.asList(genres.split(","));
        userPreferenceService.clearPreferences(userId, "genre");
        genreList.forEach(genre -> userPreferenceService.addPreference(userId, "genre", genre.trim()));

        return "redirect:/";
    }
}
