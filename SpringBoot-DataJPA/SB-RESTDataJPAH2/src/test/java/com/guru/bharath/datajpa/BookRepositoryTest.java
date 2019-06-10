package com.guru.bharath.datajpa;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.guru.bharath.datajpa.model.Book;
import com.guru.bharath.datajpa.repositories.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository BookRepository;
	
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setId(3l);
		book.setName("Bharath Victories");
		book.setPublicationDate(LocalDate.now());
		BookRepository.save(book);
		
		//assertEquals(HttpStatus.CREATED, status);
	}
	
}
