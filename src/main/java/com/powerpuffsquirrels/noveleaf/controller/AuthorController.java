package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.AuthorDto;
import com.powerpuffsquirrels.noveleaf.Service.imp.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorService author_service;

    public AuthorController(AuthorService author_service) {
        this.author_service = author_service;
    }

    @GetMapping("/authors")
    public String listAuthors(Model model) {
        List<AuthorDto> authors = author_service.getAllAuthors();

        model.addAttribute("authors", authors);

        return "authors";

    }




}