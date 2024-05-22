package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.repository.BookAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.repository.ReadShelfRepository;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import java.util.List;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    public List<BookAuthor> getBookAuthorsByIsbn(String isbn) {
        return bookAuthorRepository.findByBookIsbn(isbn);
    }

}
