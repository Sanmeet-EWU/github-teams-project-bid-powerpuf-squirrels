package com.powerpuffsquirrels.noveleaf.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {
    @Id
    private String isbn; // Primary key
    private String title;
    private String genre;

    @Transient
    private String coverImageUrl;
    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<BookAuthor> bookAuthors = new ArrayList<>();

//    public List<BookAuthor> getBookAuthorList() {
//        return bookAuthors;
//    }

    public String getAuthorNames() {
        StringBuilder authorNames = new StringBuilder();
        for (BookAuthor bookAuthor : bookAuthors) {
            if (authorNames.length() > 0) {
                authorNames.append(", ");
            }
            authorNames.append(bookAuthor.getAuthor().getFullName());
        }
        return authorNames.toString();
    }

    public void addAuthor(String fullname) {
        String[] names = fullname.split(" ");
        String firstName = (names.length > 0 && !names[0].isEmpty()) ? names[0] : "N/A";
        String lastName = (names.length > 1 && !names[1].isEmpty()) ? names[1] : "N/A";

        Author author = Author.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        BookAuthor bookAuthor = BookAuthor.builder()
                .author(author)
                .book(this)
                .build();

        bookAuthors.add(bookAuthor);
    }

    public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthors) {
            authors.add(bookAuthor.getAuthor());
        }
        return authors;
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        bookAuthors.add(bookAuthor);

    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }


}
