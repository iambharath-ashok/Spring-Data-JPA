package com.guru.bharath.datajpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.guru.bharath.datajpa.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person> findByFirstName(String firstName);
}
