package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthor.BookAuthorID>{
}
