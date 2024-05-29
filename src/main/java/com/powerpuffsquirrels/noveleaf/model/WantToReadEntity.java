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
@Table(name = "want_to_read_shelf")
public class WantToReadEntity {
    // Getters and Setters I was making trying to find a bug.
    // could delete because we have @Setters/@Getters, but what if it breaks something :(

    @Id
    String isbn;

    @Column(nullable = false, name="user_id")
    int userId;

    Date dateAdded;

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

}
