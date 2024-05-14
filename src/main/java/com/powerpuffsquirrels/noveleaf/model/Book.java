package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;

import java.sql.Date;

// This is using the JPA (Java Persistence API) to define the Book entity
// This allows for high level database access and manipulation
// might need to look into it some more

@Entity
@Table(name = "books")
public class Book {

    @Id
    private String isbn; // Primary key
    private String title;
    private Date pubDate;
    private int pubId;
    private String category;

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
