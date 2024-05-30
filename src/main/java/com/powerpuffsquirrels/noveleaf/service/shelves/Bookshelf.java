package com.powerpuffsquirrels.noveleaf.service.shelves;

public interface Bookshelf {

    default void addBook(String isbn){
    }

    void removeBook(String isbn);

    void searchBook(String title);

}
