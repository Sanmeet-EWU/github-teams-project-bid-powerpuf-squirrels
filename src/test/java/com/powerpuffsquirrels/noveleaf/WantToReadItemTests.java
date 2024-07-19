package com.powerpuffsquirrels.noveleaf;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.shelves.WantToReadItem;
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
class WantToReadItemTests {

	@Mock
	private AuthorService authorService;

	@Mock
	private BookService bookService;

	@Mock
	private BookAuthorService bookAuthorService;

	@Mock
	private WantToReadEntity wantToReadEntity;

	@InjectMocks
	private WantToReadItem wantToReadItem;

	private Book book;
	private List<Author> authors;
	private List<BookAuthor> bookAuthors;


	@BeforeEach
	void setUp() {
		this.wantToReadItem = new WantToReadItem(wantToReadEntity, authorService, bookService, bookAuthorService);
	}

	@Test
	void notNull() {
		assert(this.wantToReadItem != null);
	}

	@Test
	void makeWantToReadItem() {
		wantToReadEntity = new WantToReadEntity();
		wantToReadEntity.setUserId(1234);
		wantToReadEntity.setIsbn("123456789");
		wantToReadEntity.setDateAdded(java.sql.Date.valueOf("2000-01-01"));

		this.wantToReadItem = new WantToReadItem(wantToReadEntity, authorService, bookService, bookAuthorService);

		assert(this.wantToReadItem.getIsbn().equals("123456789"));
	}

}