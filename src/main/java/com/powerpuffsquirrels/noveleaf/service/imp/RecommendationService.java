package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {


    private final UserPreferenceService userPreferenceService;

    private final RecommendationApiClient recommendationApiClient;

    @Autowired
    public RecommendationService(UserPreferenceService userPreferenceService, RecommendationApiClient recommendationApiClient) {
        this.userPreferenceService = userPreferenceService;
        this.recommendationApiClient = recommendationApiClient;
    }

    public List<Book> generateRecommendations(Integer userId) {
        List<Preference> preference = userPreferenceService.getUserPreferences(userId);
        return recommendationApiClient.getRecommendations(preference);
    }
}
