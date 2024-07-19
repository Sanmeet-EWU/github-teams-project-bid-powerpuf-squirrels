package com.powerpuffsquirrels.noveleaf.controller;

import com.powerpuffsquirrels.noveleaf.DataTransferObj.UserDto;
import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import com.powerpuffsquirrels.noveleaf.repository.WantToReadRepository;
import com.powerpuffsquirrels.noveleaf.service.imp.*;
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
    private UserDto user;

    @Autowired
    private WantToReadService wantReadShelfService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @Autowired
    ReadShelfService readShelfService;

    @Autowired
    ReadingGoalService goalService;


    @GetMapping("/wanttoreadshelf")
    public String loadBooks(WantToReadRepository readShelfRepository, AuthorRepository AuthorRepo, BookRepository BookRepo, BookAuthorRepository BookAuthRepo, Model model, HttpSession session) {
        this.user = (UserDto) session.getAttribute("user");

        model.addAttribute("userAccount", this.user);


        //Too lazy to change constructor object for readshelf :)
        this.userAccount = new UserAccount();
        this.userAccount.setUserID(this.user.getUserID());
        this.userAccount.setUsername(this.user.getUsername());

        //build WantToRead, which will be done automatically in the readShelf constructor
        this.wantToReadShelf = new WantToReadShelf(this.userAccount, wantReadShelfService, authorService, bookService, bookAuthorService); //and this

        //I was going to try and get the readShelfItems without having to basically copy the list in the readShelf
        //but you sort of need a list of objects for thymeleaf to iterate through. idk, what's done is done, lel.
        List<WantToReadItem> readShelfItems = wantToReadShelf.getItems();

        model.addAttribute("readShelfItems", readShelfItems);


        return "wanttoreadshelf";
    }

    //This shit is currently not working
    @PostMapping("/readwantedbook")
    public String submitBook(int index, Model model) {
        WantToReadItem item = this.wantToReadShelf.getItems().get(index);
        readShelfService.addReadShelfItem(item.getIsbn(), this.user.getUserID());
        goalService.updateGoals(this.user.getUserID(), 1);
        return "redirect:/readshelf";

    }

}