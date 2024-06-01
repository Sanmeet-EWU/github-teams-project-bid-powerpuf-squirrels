package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.service.imp.BestSellingBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BestSellingBooksController {

    @Autowired
    private BestSellingBooksService bestSellingBooksService;

    @GetMapping("/best-sellers")
    public String getBestSellingBooks(Model model) {
        List<Book> books = bestSellingBooksService.getBestSellingBooks();
        model.addAttribute("books", books);
        return "bestSellingBooks";
    }
}
