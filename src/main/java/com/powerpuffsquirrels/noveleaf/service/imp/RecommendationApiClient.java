package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookItem;
import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookResponse;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationApiClient {

    private final RestTemplate restTemplate;
    private String apiKey = "AIzaSyBmOmu9r5teEGvPnTJIKvCSQYpaKvNXb_E";

    public RecommendationApiClient() {
        this.restTemplate = new RestTemplate();
    }


    public List<BookItem> fetchBooksByGenre(String genre) {
        String baseUrl = "https://www.googleapis.com/books/v1/volumes";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("q", "subject:" + genre)
                .queryParam("apiKey", apiKey);

        RestTemplate restTemplate = new RestTemplate();
        BookResponse response = restTemplate.getForObject(builder.toUriString(), BookResponse.class);

        return response.getItems(); // Assuming 'items' contains the list of books
    }


    public List<Book> getRecommendations(List<Preference> preferences) {
        String apiUrl = "https://api.example.com/recommendations";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl);

        for (Preference pref : preferences) {
            builder.queryParam(pref.getPref_type(), pref.getValue());
        }

        ResponseEntity<Book[]> response = restTemplate.getForEntity(builder.toUriString(), Book[].class);
        return Arrays.asList(response.getBody());
    }
}
