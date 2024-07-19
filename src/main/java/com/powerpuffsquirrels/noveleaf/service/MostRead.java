package com.powerpuffsquirrels.noveleaf.service;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class MostRead {
    private List<Book> mostReadBooks;


    //constuctor
    @Autowired
    public MostRead(ReadShelfService readShelfService, BookService bookService) {
        mostReadBooks = new ArrayList<>();

        readShelfService.mostAdded7Days().forEach(isbn -> {
            mostReadBooks.add(bookService.getBookByIsbn(isbn));
        });

        //test if it is creating a list of Strings
        readShelfService.mostAdded7Days().forEach(isbn -> {
            System.out.println("this isbn is: " + isbn + "\n");
        });


    }

    public void buildMostReadBooks(ReadShelfService readShelfService, BookService bookService) {


//        readShelfService.mostAdded7Days().forEach(isbn -> {
//            System.out.println("this isbn is: " + isbn + "\n");
//        });

//        readShelfService.mostAdded7Days().forEach(isbn -> {
//            mostReadBooks.add(bookService.getBookByIsbn(isbn));
//        });
    }

    public List<Book> getMostReadBooks() {
        return mostReadBooks;
    }
}
