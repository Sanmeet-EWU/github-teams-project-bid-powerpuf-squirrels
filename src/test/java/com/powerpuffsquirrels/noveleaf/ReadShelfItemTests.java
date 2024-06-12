package com.powerpuffsquirrels.noveleaf;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.model.ReadShelfEntity;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.shelves.ReadShelfItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

//import support for @Mock


@SpringBootTest
class ReadShelfItemTests {

	@Mock
	private AuthorService authorService;

	@Mock
	private BookService bookService;

	@Mock
	private BookAuthorService bookAuthorService;

	@Mock
	private ReadShelfEntity readShelfEntity;

	@InjectMocks
	private ReadShelfItem readShelfItem;

	private Book book;
	private List<Author> authors;
	private List<BookAuthor> bookAuthors;


	@BeforeEach
	void setUp() {
		this.readShelfItem = new ReadShelfItem(readShelfEntity, authorService, bookService, bookAuthorService);
	}

	@Test
	void notNull() {
		assert(this.readShelfItem != null);
	}

    @Test
    void makeReadShelfItem() {
        readShelfEntity = new ReadShelfEntity();
		readShelfEntity.setUserId(1234);
		readShelfEntity.setIsbn("123456789");
		readShelfEntity.setRating(4);
		readShelfEntity.setDateAdded(java.sql.Date.valueOf("2000-01-01"));

		this.readShelfItem = new ReadShelfItem(readShelfEntity, authorService, bookService, bookAuthorService);

		assert(this.readShelfItem.getIsbn().equals("123456789"));
		assert(this.readShelfItem.getRating() == 4);
    }

}