package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "q", required = false) String query, Model model) {
        if (query != null && !query.isEmpty()) {
            String url = "https://openlibrary.org/search.json?q=" + query;
            String jsonResponse = restTemplate.getForObject(url, String.class);

            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(jsonResponse);
                JsonNode docs = root.path("docs");

                List<Book> books = new ArrayList<>();
                for (JsonNode doc : docs) {
                    Book book = new Book();
                    book.setIsbn(!doc.path("isbn").isEmpty() ? doc.path("isbn").get(0).asText() : "N/A");
                    book.setTitle(doc.path("title").asText());
                    book.setAuthorName(!doc.path("author_name").isEmpty() ? doc.path("author_name").get(0).asText() : "N/A");
                    books.add(book);
                }
                model.addAttribute("books", books);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "search";
    }
}
