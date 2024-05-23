package com.powerpuffsquirrels.noveleaf.repository;

import com.powerpuffsquirrels.noveleaf.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String>{
    //List<Author> findByAuthorsByIsbn(String isbn);

    Author findByAuthorID(int authorId);

    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
    // You can define custom query methods here if needed, but Spring Data JPA will provide most of the basic CRUD operations
}
