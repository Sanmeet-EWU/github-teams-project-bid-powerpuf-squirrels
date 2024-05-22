package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@Table(name = "read_shelf")
public class ReadShelfEntity {
    @Id
    String isbn;

    @Column(nullable = false, name="user_id")
    int userId;

    Date dateAdded;
    int rating;

    // Getters and Setters I was making trying to find a bug.
    // could delete because we have @Setters/@Getters, but what if it breaks something :(
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
