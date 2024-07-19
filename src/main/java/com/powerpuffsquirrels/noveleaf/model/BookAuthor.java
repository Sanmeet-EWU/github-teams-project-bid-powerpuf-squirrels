package com.powerpuffsquirrels.noveleaf.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(BookAuthor.BookAuthorID.class)
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @ManyToOne
    @JsonBackReference

    @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false)
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", nullable = false)
    private Author author;

    public int getAuthorId() {
        return author.getAuthorID();
    }

    @Getter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookAuthorID implements Serializable {
        private String book;
        private Integer author;
    }

    public String getIsbn() {
        return book.getIsbn();
    }
}
