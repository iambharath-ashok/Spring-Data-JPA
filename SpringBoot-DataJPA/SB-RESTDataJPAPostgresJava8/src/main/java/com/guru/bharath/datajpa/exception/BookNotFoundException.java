package com.guru.bharath.datajpa.exception;

import java.util.function.Supplier;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(Long id) {
		System.out.print("Not found Id: "+id);
	}


}
