package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookItem;
import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.service.imp.RecommendationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendations")
    public String getRecommendations(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userID");
        model.addAttribute("userAccount", (UserDto) session.getAttribute("user"));

        List<RecommendationService.GenreRecommendations> recommendations = recommendationService.getRecsByGenre(userId);
        model.addAttribute("userID", userId);
        model.addAttribute("recommendations", recommendations);
        return "recommendations";
    }
}

