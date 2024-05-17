package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor (access = AccessLevel.PRIVATE)//I'm assuming your parameterized constructor doesn't set rating on purpose when building hence why this isn't public
@Builder //defining an AllArgsConstructor is necessary for the builder, IDK why, since it already has access to a no arg constructor and setters
@IdClass(InShelf.InShelfId.class )
@Table(name = "in_shelf")
public class InShelf {

    @Id
    @Column(nullable = false)
    private String isbn;

    @Id
    @Column(nullable = false, name = "shelf_id")
    private Integer shelfID;

    @Setter
    @Column(nullable = false, name = "date_added")
    private java.sql.Date dateAdded;

    @Setter
    private byte rating;

    @Getter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InShelfId implements Serializable {
        private String isbn;
        private Integer shelfID;

        // Getter and Setter handled by @Data
    }
}