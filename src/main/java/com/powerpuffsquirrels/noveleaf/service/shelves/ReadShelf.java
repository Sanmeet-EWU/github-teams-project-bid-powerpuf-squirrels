package com.powerpuffsquirrels.noveleaf.service.shelves;

import com.powerpuffsquirrels.noveleaf.model.UserAccount;
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
import org.springframework.data.jpa.repository.Query;


import java.util.ArrayList;
import java.util.List;

public class ReadShelf implements Bookshelf {
    private List<ReadShelfItem> readShelfItems ;
    private UserAccount UserAccount; //idk if we might need this at some point

    public ReadShelf(UserAccount UserAccount, ReadShelfService readShelfService, AuthorService authorService, BookService bookService, BookAuthorService bookAuthorService) {
        this.UserAccount = UserAccount;

        List<ReadShelfEntity> readShelfEntities = readShelfService.getReadShelvesByUserId(UserAccount.getUserID());
        if (readShelfEntities.isEmpty()){
            return;
        }

        System.out.println("isbn is " + readShelfEntities.get(0).getIsbn());


        this.readShelfItems = new ArrayList<>();

        //for every readShelfEntities, call readShelfItems.add(readShelfEntity)
        //will need the readShelfEntity, Author, and Book entities.


        for (int i = 0; readShelfEntities.size() > i; i++){
            readShelfItems.add(new ReadShelfItem(readShelfEntities.get(i), authorService, bookService, bookAuthorService));
        }
    }


    //everything below here is jank shit that I havent sorted out yet.
    @Override
    public void addBook(String isbn) {
        throw new UnsupportedOperationException();
    }

    public void removeBook(String isbn) {
        //Remove the ReadShelfItem
    }

    public void searchBook(String title) {
        // TODO - implement ReadShelf.searchBook
        throw new UnsupportedOperationException();
    }

    public List<ReadShelfItem> getItems() {
        return readShelfItems;
    }



}
