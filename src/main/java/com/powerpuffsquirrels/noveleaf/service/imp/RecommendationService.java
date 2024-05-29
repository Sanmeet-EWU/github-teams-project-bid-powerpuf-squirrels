package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookItem;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import com.powerpuffsquirrels.noveleaf.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {



    private final PreferencesRepository preferencesRepository;
    private final RecommendationApiClient recommendationApiClient;

    @Autowired
    public RecommendationService(PreferencesRepository preferencesRepository, RecommendationApiClient recommendationApiClient) {
        this.preferencesRepository = preferencesRepository;
        this.recommendationApiClient = recommendationApiClient;
    }

    public List<GenreRecommendations> getRecsByGenre(Integer userId) {
        List<Preference> genrePreferences = preferencesRepository.findByUser_UserIDAndPrefType(userId, "genre");

        List<GenreRecommendations> genreRecommendationsList = new ArrayList<>();

        for (Preference genrePreference : genrePreferences) {
            List<BookItem> recommendations = recommendationApiClient.fetchBooksByGenre(genrePreference.getValue());
            genreRecommendationsList.add(new GenreRecommendations(genrePreference.getValue(), recommendations));
        }

        return genreRecommendationsList;
    }

    public static class GenreRecommendations {
        private String genre;
        private List<BookItem> recommendations;

        public GenreRecommendations(String genre, List<BookItem> recommendations) {
            this.genre = genre;
            this.recommendations = recommendations;
        }

        public String getGenre() {
            return genre;
        }

        public List<BookItem> getRecommendations() {
            return recommendations;
        }
    }
}
