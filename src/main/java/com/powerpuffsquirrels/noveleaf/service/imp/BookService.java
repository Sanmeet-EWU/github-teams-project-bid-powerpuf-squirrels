package com.powerpuffsquirrels.noveleaf.service.imp;

import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.powerpuffsquirrels.noveleaf.repository.ReadShelfRepository;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
