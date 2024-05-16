package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @Column(nullable = false)
    private String isbn; //primary key

    @Id
    @Column(nullable = false, name = "author_id")
    private Integer authorID;

    public BookAuthor(){ }

    public BookAuthor(String isbn, Integer authorID){
        this.authorID = authorID;
        this.isbn = isbn;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public Integer getAuthorID(){
        return this.authorID;
    }

}
