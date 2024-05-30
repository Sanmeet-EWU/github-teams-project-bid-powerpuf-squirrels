package com.powerpuffsquirrels.noveleaf.service.shelves;

import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import com.powerpuffsquirrels.noveleaf.model.UserAccount;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.WantToReadService;

import java.util.ArrayList;
import java.util.List;

public class WantToReadShelf implements Bookshelf {
    private List<WantToReadItem> wantToReadItems;
    private UserAccount UserAccount; //idk if we might need this at some point

    public WantToReadShelf(UserAccount UserAccount, WantToReadService readShelfService, AuthorService authorService, BookService bookService, BookAuthorService bookAuthorService) {
        this.UserAccount = UserAccount;

        List<WantToReadEntity> readShelfEntities = readShelfService.getReadShelvesByUserId(UserAccount.getUserID());
        if (readShelfEntities.isEmpty()){
            return;
        }

        System.out.println("isbn is " + readShelfEntities.get(0).getIsbn());


        this.wantToReadItems = new ArrayList<>();

        //for every readShelfEntities, call readShelfItems.add(readShelfEntity)
        //will need the readShelfEntity, Author, and Book entities.


        for (int i = 0; readShelfEntities.size() > i; i++){
            wantToReadItems.add(new WantToReadItem(readShelfEntities.get(i), authorService, bookService, bookAuthorService));
        }
    }


    //everything below here is jank shit that I havent sorted out yet.
    @Override
    public void addBook(String isbn) {
        throw new UnsupportedOperationException();
    }

    public void removeBook(String isbn) {
        //Remove the WantToReadItem
    }

    public void searchBook(String title) {
        // TODO - implement WantToRead.searchBook
        throw new UnsupportedOperationException();
    }

    public List<WantToReadItem> getItems() {
        return wantToReadItems;
    }

    //nothing calling this yet, but should work
//    public List<WantToReadItem> sortByRating() {
//        readShelfItems.sort(Comparator.comparing(WantToReadItem::getRating).reversed());
//        return readShelfItems;
//    }


}
