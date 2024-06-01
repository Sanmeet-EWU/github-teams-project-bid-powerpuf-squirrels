package com.powerpuffsquirrels.noveleaf.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerpuffsquirrels.noveleaf.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestSellingBooksService {

    @Value("${nyt.api.key}")
    private String apiKey;

    private static final String URL = "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=";

    public List<Book> getBestSellingBooks() {
        String requestUrl = URL + apiKey;
        System.out.println("NYT API Key: " + apiKey); // Debug statement
        System.out.println("Request URL: " + requestUrl); // Debug statement

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(requestUrl, String.class);
        System.out.println("API Response: " + response); // Debug statement

        List<Book> books = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode resultsNode = rootNode.path("results").path("books");
            if (resultsNode.isArray()) {
                for (JsonNode bookNode : resultsNode) {
                    Book book = new Book();
                    book.setIsbn(bookNode.path("primary_isbn13").asText());
                    book.setTitle(bookNode.path("title").asText());
                    book.setGenre("Fiction"); // Assuming genre as 'Fiction' since the API endpoint is for hardcover fiction
                    book.setCoverImageUrl(bookNode.path("book_image").asText()); // Correctly set coverImageUrl
                    book.addAuthor(bookNode.path("author").asText());
                    books.add(book);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Parsed Books: " + books); // Debug statement
        return books;
    }
}
