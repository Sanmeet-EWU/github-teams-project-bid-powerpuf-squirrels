package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, String>{
    //List<Author> findByAuthorsByIsbn(String isbn);

    Author findByAuthorID(int authorId);
    // You can define custom query methods here if needed, but Spring Data JPA will provide most of the basic CRUD operations
}
