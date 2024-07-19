package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthor.BookAuthorID> {
//    //find list of books by isbn
    //List<BookAuthor> findByisbn(String isbn);

    List<BookAuthor> findByBookIsbn(String isbn);

}
