package com.guru.bharath.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.datajpa.model.Book;
import com.guru.bharath.datajpa.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBook() {
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@PostMapping(path = "/addNew")
	public ResponseEntity<HttpStatus> addNewBook(@RequestBody Book book) {
		return ResponseEntity.status(bookService.addBook(book)).build();
	}

	@PutMapping(path="/update")
	public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book) {
		return new ResponseEntity<HttpStatus>(bookService.updateBook(book));
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBookById(@PathVariable Long id) {
		bookService.deleteBook(id);
	}

}
