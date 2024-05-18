package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@IdClass(BookAuthor.BookAuthorID.class )
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @ManyToOne
    @JoinColumn(name = "isbn", referencedColumnName ="isbn", nullable = false)
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", nullable = false)
    private Author author;

    @Getter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookAuthorID implements Serializable {
        private String book;
        private Integer author;
    }

}
