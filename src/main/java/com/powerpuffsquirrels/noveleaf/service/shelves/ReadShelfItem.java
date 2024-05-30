package com.powerpuffsquirrels.noveleaf.service.shelves;
import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;

//import list
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ReadShelfItem {
    private Book book;
    private List<Author> authors = new ArrayList<>();
    private final ReadShelfEntity readShelfEntity;

    public ReadShelfItem(ReadShelfEntity readShelfEntity, AuthorService authorService, BookService bookService, BookAuthorService bookAuthorService) {
        this.readShelfEntity = readShelfEntity;
        this.book = bookService.getBookByIsbn(readShelfEntity.getIsbn());
        this.authors = new ArrayList<>();

        //get author_ids from book_author
        List<BookAuthor> bookAuthors = bookAuthorService.getBookAuthorsByIsbn(readShelfEntity.getIsbn());

        //get author objects from author_ids
        for (int i = 0; i < bookAuthors.size(); i++) {
            int authorId = bookAuthors.get(i).getAuthor().getAuthorID();
            Author author = authorService.getAuthorByAuthorId(authorId);
            System.out.println("author is " + author.getFullName());
            this.authors.add(author);
        }

    }

    public void setRating(int rating) {
        this.readShelfEntity.setRating(rating);
    }

    public int getRating() {
        return this.readShelfEntity.getRating();
    }

    public Date getDateAdded() {
        return this.readShelfEntity.getDateAdded();
    }

    public String getIsbn() {
        return this.readShelfEntity.getIsbn();
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