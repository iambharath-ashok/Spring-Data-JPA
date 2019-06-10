package com.guru.bharath.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.datajpa.model.Book;
import com.guru.bharath.datajpa.service.BookService;

@RestController
@RequestMapping(path="book")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping(path="/getAll")
	public List<Book> getAllBooks() {
		return bookService.findAllBooks();
	}
	
	@GetMapping(path="/getByName/{name}")
	public List<Book> getBookByName(@PathVariable String name) {
		return bookService.findByBookName(name);
	}
	
	@PostMapping(path="/addNew")
	public HttpStatus addNewBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping(path="/update")
	public HttpStatus updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping
	public HttpStatus deleteBookById(@PathVariable Long id) {
		return bookService.deleteBookById(id);
	}
	
}
