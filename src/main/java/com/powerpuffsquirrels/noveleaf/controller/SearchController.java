package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadShelfService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    private UserDto user;
    private List<Book> books;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private BookService bookService;
    @Autowired
    ReadShelfService readShelfService;
    @Autowired
    BookAuthorService bookAuthorService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/search")
    public String searchBooks(@RequestParam(name = "q", required = false) String query, Model model, HttpSession session) {

        this.user = (UserDto) session.getAttribute("user");
        //This will allow us to display different elements based on whether the user is logged in
        model.addAttribute("userAccount", (UserDto) session.getAttribute("user"));

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
                    book.setBookAuthors(new ArrayList<>());
                    if (!doc.path("author_name").isEmpty()) {
                        for (JsonNode author : doc.path("author_name")) {
                            book.addAuthor(author.asText());
                        }
                    }
                    books.add(book);
                }
                model.addAttribute("books", books);
                this.books = books;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "search";
    }

    @PostMapping("/search")
    public ResponseEntity<String> submitBook(int index, Model model) {
        //I think you need to add them in the order of Aythor, BookAuthor, Book

        //add author to author table
        Author author = this.books.get(index).getAuthors().get(0);
        authorService.addAuthor(author);

        //add book to book table along with book_author
        //Genre is still a WIP since the API gives some jank results
        bookService.addBookWithAuthor(this.books.get(index).getIsbn(), this.books.get(index).getTitle(), "WIP", author.getFirstName(), author.getLastName());

        //add book to read shelf
        readShelfService.addReadShelfItem(this.books.get(index).getIsbn(), user.getUserID());

        //yes, this will always return ok. Can mess with it more later
        return ResponseEntity.ok(this.books.get(index).getTitle() + " has been added to your read shelf!");

        //need to look more into return "redirect:/readshelf"; as a possible alternative

    }
}
