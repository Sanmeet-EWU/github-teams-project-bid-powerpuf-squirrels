package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookItem;
import com.powerpuffsquirrels.noveleaf.DataTransferObj.BookResponse;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RecommendationApiClient {

    private final RestTemplate restTemplate;
    private final String apiKey = "AIzaSyBmOmu9r5teEGvPnTJIKvCSQYpaKvNXb_E";

    public RecommendationApiClient() {
        this.restTemplate = new RestTemplate();
    }


    public List<BookItem> fetchBooksByGenre(String genre) {
        String baseUrl = "https://www.googleapis.com/books/v1/volumes";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("q", "subject:" + genre)
                .queryParam("apiKey", apiKey)
                .queryParam("maxResults", 5)
                .queryParam("orderBy", "newest");
        BookResponse response = restTemplate.getForObject(builder.toUriString(), BookResponse.class);

        return response != null ? response.getItems() : Collections.emptyList(); // Handling potential null response
    }

}
