package com.guru.bharath.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.guru.bharath.datajpa.exception.BookNotFoundException;
import com.guru.bharath.datajpa.model.Book;
import com.guru.bharath.datajpa.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	
	public Book getBookById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	public HttpStatus addBook(Book book) {
		return bookRepo.save(book)!=null? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	
	public HttpStatus updateBook(Book book) {
		return bookRepo.save(book)!=null ?HttpStatus.ACCEPTED: HttpStatus.NOT_MODIFIED;
	}
	
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
