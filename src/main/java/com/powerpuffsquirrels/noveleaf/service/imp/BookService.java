package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.repository.AuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.repository.ReadShelfRepository;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void saveBook(Book book) {
        for (BookAuthor bookAuthor : book.getBookAuthors()) {
            authorRepository.save(bookAuthor.getAuthor());
        }
        bookRepository.save(book);
    }

    @Transactional
    public void addBookWithAuthor(String isbn, String title, String genre, String firstName, String lastName) {
        // Save the book
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setGenre(genre);
        bookRepository.save(book);

        // Check if the author exists, if not, save the author
        Author author = authorRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setFirstName(firstName);
                    newAuthor.setLastName(lastName);
                    return authorRepository.save(newAuthor);
                });

        // Save the BookAuthor entity
        BookAuthor bookAuthor = new BookAuthor();
        bookAuthor.setBook(book);
        bookAuthor.setAuthor(author);
        bookAuthorRepository.save(bookAuthor);
    }
}
