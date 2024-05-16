package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.DateJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Date;

@Entity
@Table(name = "in_shelf")
public class InShelf {
    @Id
    @Column(nullable = false)
    private String isbn;

    @Id
    @Column(nullable = false, name = "shelf_id")
    private Integer shelfID;

    @Column(nullable = false, name = "dateAdded")
    private DateJdbcType dateAdded;

    private TinyIntJdbcType rating;

    public InShelf() {}

    public InShelf(String isbn, Integer shelfID, DateJdbcType dateAdded){
        this.isbn = isbn;
        this.shelfID = shelfID;
        this.dateAdded = dateAdded;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getShelfID() {
        return shelfID;
    }

    public DateJdbcType getDateAdded() {
        return dateAdded;
    }

    public TinyIntJdbcType getRating() {
        return rating;
    }

    public void setRating(TinyIntJdbcType rating) {
        this.rating = rating;
    }

    public void setDateAdded(DateJdbcType dateAdded) {
        this.dateAdded = dateAdded;
    }
}
