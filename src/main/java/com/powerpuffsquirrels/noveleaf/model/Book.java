package com.powerpuffsquirrels.noveleaf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> bookAuthors;

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
        String[] names = fullname.split(" ");// since we are now storing first and last name separately, we need to split the full name

        // Determine the first name and last name
        String firstName = (names.length > 0 && !names[0].isEmpty()) ? names[0] : "N/A"; //throws errors if its empty
        String lastName = (names.length > 1 && !names[1].isEmpty()) ? names[1] : "N/A";

        // I hate builders
        Author author = Author.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();

        BookAuthor bookAuthor = BookAuthor.builder()
                .author(author)
                .book(this)
                .build();

        // Add the BookAuthor to the list
        bookAuthors.add(bookAuthor);
    }

}
