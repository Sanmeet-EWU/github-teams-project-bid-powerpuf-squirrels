package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import com.powerpuffsquirrels.noveleaf.repository.WantToReadRepository;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.WantToReadService;
import com.powerpuffsquirrels.noveleaf.service.shelves.WantToReadShelf;
import com.powerpuffsquirrels.noveleaf.service.shelves.WantToReadItem;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WantToReadController {
    private UserAccount userAccount;
    //private WantToReadRepository readShelfRepository;
    private WantToReadShelf wantToReadShelf;


    @Autowired
    private WantToReadService readShelfService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;


    @GetMapping("/wanttoreadshelf")
    public String loadBooks(WantToReadRepository readShelfRepository, AuthorRepository AuthorRepo, BookRepository BookRepo, BookAuthorRepository BookAuthRepo, Model model, HttpSession session) {
        UserDto user = (UserDto) session.getAttribute("user");
        model.addAttribute("userAccount", (UserDto) session.getAttribute("user"));


        //Too lazy to change constructor object for readshelf :)
        this.userAccount = new UserAccount();
        this.userAccount.setUserID(user.getUserID());
        this.userAccount.setUsername(user.getUsername());

        //build WantToRead, which will be done automatically in the readShelf constructor
        this.wantToReadShelf = new WantToReadShelf(this.userAccount, readShelfService, authorService, bookService, bookAuthorService); //and this

        //I was going to try and get the readShelfItems without having to basically copy the list in the readShelf
        //but you sort of need a list of objects for thymeleaf to iterate through. idk, what's done is done, lel.
        List<WantToReadItem> readShelfItems = wantToReadShelf.getItems();

        model.addAttribute("readShelfItems", readShelfItems);


        return "wanttoreadshelf";
    }

    //This shit is currently not working
    @PostMapping("/wanttoreadshelf")
    public String rateBook(@RequestParam("isbn") String isbn, @RequestParam("rating") int rating, HttpSession session) {
        // Logic to handle the rating, e.g., save the rating to the database
        UserDto user = (UserDto) session.getAttribute("user");

        // Call your service to handle the rating logic
        //readShelfService.rateBook(isbn, rating, user);

        System.out.println("Rating book with ISBN: " + isbn + " with rating: " + rating);

        //update read_shelf
        readShelfService.updateWantToReadItem(isbn, rating, user.getUserID());

        // Redirect to the readshelf page or any other page
        return "redirect:/wanttoreadshelf";
    }

}