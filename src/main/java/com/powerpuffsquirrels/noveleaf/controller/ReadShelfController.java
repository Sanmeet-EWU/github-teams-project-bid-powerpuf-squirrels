package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import com.powerpuffsquirrels.noveleaf.repository.ReadShelfRepository;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.powerpuffsquirrels.noveleaf.service.shelves.*;

import java.util.ArrayList;
import java.util.List;

import com.powerpuffsquirrels.noveleaf.model.UserAccount;

@Controller
public class ReadShelfController {
    private UserAccount userAccount;
    //private ReadShelfRepository readShelfRepository;
    private ReadShelf readShelf;


    @Autowired
    private ReadShelfService readShelfService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;


    @GetMapping("/readshelf")
    public String loadBooks(ReadShelfRepository readShelfRepository, AuthorRepository AuthorRepo, BookRepository BookRepo, BookAuthorRepository BookAuthRepo, Model model) {
        //this.readShelfRepository = readShelfRepository; //this is just tempory, will be deleted later
        /**
         * I imagine we are going to need to get the session of the user account that is logged in,
         * then we will need to build the user account, which we can pull the user_id from to build the read shelf
         */

        //since login is still WIP, I am just building this manually
        this.userAccount = new UserAccount();
        this.userAccount.setUserID(123);

        //build ReadShelf, which will be done automatically in the readShelf constructor
        this.readShelf = new ReadShelf(this.userAccount, readShelfService, authorService, bookService, bookAuthorService); //and this

        //I was going to try and get the readShelfItems without having to basically copy the list in the readShelf
        //but you sort of need a list of objects for thymeleaf to iterate through. idk, what's done is done, lel.
        List<ReadShelfItem> readShelfItems = readShelf.getItems();

        model.addAttribute("readShelfItems", readShelfItems);

        return "readshelf";
    }

    //Maybe I'll do this later
//    @GetMapping("/readshelf")
//    public String searchBooks(Model model) {
//        System.out.println("test");
//        List<ReadShelfEntity> readBooks = readShelfRepository.findByUserID(userAccount.getUserID());
//        model.addAttribute("readBooks", readBooks);
//
//        return "readshelf";
//    }

}