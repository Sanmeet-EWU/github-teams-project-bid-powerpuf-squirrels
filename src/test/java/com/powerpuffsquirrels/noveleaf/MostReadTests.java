package com.powerpuffsquirrels.noveleaf;

import com.powerpuffsquirrels.noveleaf.model.Author;
import com.powerpuffsquirrels.noveleaf.model.Book;
import com.powerpuffsquirrels.noveleaf.model.BookAuthor;
import com.powerpuffsquirrels.noveleaf.model.WantToReadEntity;
import com.powerpuffsquirrels.noveleaf.service.MostRead;
import com.powerpuffsquirrels.noveleaf.service.imp.AuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookAuthorService;
import com.powerpuffsquirrels.noveleaf.service.imp.BookService;
import com.powerpuffsquirrels.noveleaf.service.imp.ReadShelfService;
import com.powerpuffsquirrels.noveleaf.service.shelves.WantToReadItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import support for @Mock


@SpringBootTest
class MostReadTests {

	@Mock
	private MostRead mostRead;

	@Mock
	private ReadShelfService readShelfService;

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
		this.mostRead = new MostRead(this.readShelfService, this.bookService);
	}

	@Test
	void checkIfNull() {
		assert (this.mostRead != null);
	}

	@Test
	void TestHasAtLeastOneBook() {
		Book book = this.mostRead.getMostReadBooks().get(0);
		assert (book.getTitle() != null);
		assert (book.getIsbn() != null);
	}
}