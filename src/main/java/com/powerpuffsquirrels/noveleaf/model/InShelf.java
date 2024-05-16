package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.DateJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor (access = AccessLevel.PRIVATE)//I'm assuming your parameterized constructor doesn't set rating on purpose when building hence why this isn't public
@Builder //defining an AllArgsConstructor is necessary for the builder, IDK why, since it already has access to a no arg constructor and setters
@IdClass(InShelf.InShelfId.class )
@Table(name = "in_shelf")
public class InShelf {

    @Data @AllArgsConstructor
    public class InShelfId implements Serializable {
        private String isbn;
        private Integer shelfID;

        // Getter and Setter handled by @Data
    }



    @Column(nullable = false)
    @Id
    private String isbn;


    @Column(nullable = false, name = "shelf_id")
    @Id
    private Integer shelfID;

    @Column(nullable = false, name = "dateAdded")
    private java.sql.Date dateAdded;


    private byte rating;

  //  public InShelf() {}

    public InShelf(String isbn, Integer shelfID, java.sql.Date   dateAdded){
        this.isbn = isbn;
        this.shelfID = shelfID;
        this.dateAdded = dateAdded;
    }

/*
    public String getIsbn() {
        return isbn;
    }

    public Integer getShelfID() {
        return shelfID;
    }

    public java.sql.Date   getDateAdded() {
        return dateAdded;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public void setDateAdded(java.sql.Date   dateAdded) {
        this.dateAdded = dateAdded;
    }*/
}
