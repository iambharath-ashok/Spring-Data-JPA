package com.guru.bharath.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.guru.bharath.datajpa.model.Person;
import com.guru.bharath.datajpa.repositories.PersonRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PersonService {
	

	@Autowired
	private PersonRepository personRepo;

	public List<Person> getPersonByName(String firstName) {
		return personRepo.findByFirstName(firstName);
	}

	public Person getPersonById(Long id) {
		return personRepo.findOne(id);
	}

	public List<Person> getAllPersons() {
		return (List<Person>) personRepo.findAll();
	}

	public boolean addPerson(Person person) {
		return personRepo.save(person)!=null;
	}

	public boolean updatePerson(Person person) {
		return personRepo.save(person)!=null;
	}

	public void deletePerson(Long id) {
		personRepo.delete(id);
	}

}
