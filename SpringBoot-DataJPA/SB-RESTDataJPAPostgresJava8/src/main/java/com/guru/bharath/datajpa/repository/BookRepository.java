package com.guru.bharath.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.bharath.datajpa.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
