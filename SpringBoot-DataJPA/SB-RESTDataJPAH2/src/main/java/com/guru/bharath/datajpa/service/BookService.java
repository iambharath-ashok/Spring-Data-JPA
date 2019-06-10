package com.guru.bharath.datajpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.guru.bharath.datajpa.exception.DaoException;
import com.guru.bharath.datajpa.model.Book;
import com.guru.bharath.datajpa.repositories.BookRepository;

@Service
@Transactional(rollbackOn= {DaoException.class})
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findByBookName(String name) {
		return bookRepo.findByName(name);
	}
	
	
	public List<Book> findAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}
	
	public HttpStatus addBook(Book book) {
		return bookRepo.save(book)!=null ? HttpStatus.CREATED: HttpStatus.BAD_REQUEST;
	}
	
	public HttpStatus updateBook(Book book) {
		return bookRepo.save(book)!=null ? HttpStatus.ACCEPTED : HttpStatus.NOT_ACCEPTABLE;
	}
	
	
	public HttpStatus deleteBookById(Long id) {
		bookRepo.deleteById(id);
		return HttpStatus.OK; 
	}

}
