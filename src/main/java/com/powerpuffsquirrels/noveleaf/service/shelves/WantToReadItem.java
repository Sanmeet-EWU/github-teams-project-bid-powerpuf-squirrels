package com.powerpuffsquirrels.noveleaf.service.shelves;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class WantToReadItem {
    @Getter
    private Book book;
    private List<Author> authors = new ArrayList<>();
    private final WantToReadEntity wantToReadEntity;

    public WantToReadItem(WantToReadEntity WantToReadEntity, AuthorService authorService, BookService bookService, BookAuthorService bookAuthorService) {
        this.wantToReadEntity = WantToReadEntity;
        this.book = bookService.getBookByIsbn(WantToReadEntity.getIsbn());
        this.authors = new ArrayList<>();

        //get author_ids from book_author
        List<BookAuthor> bookAuthors = bookAuthorService.getBookAuthorsByIsbn(WantToReadEntity.getIsbn());

        //get author objects from author_ids
        for (int i = 0; i < bookAuthors.size(); i++) {
            int authorId = bookAuthors.get(i).getAuthor().getAuthorID();
            Author author = authorService.getAuthorByAuthorId(authorId);
            System.out.println("author is " + author.getFullName());
            this.authors.add(author);
        }

    }

    public Date getDateAdded() {
        return this.wantToReadEntity.getDateAdded();
    }

    public String getIsbn() {
        return this.wantToReadEntity.getIsbn();
    }

    public String getTitle() {
        return this.book.getTitle();
    }

    //this is getting called by thymeleaf despite it saying no usages
    public String getAuthors() {
        StringBuilder authorString = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            authorString.append(authors.get(i).getFullName());
            if (i < authors.size() - 1) {
                authorString.append(", ");
            }
        }
        return authorString.toString();
    }
}