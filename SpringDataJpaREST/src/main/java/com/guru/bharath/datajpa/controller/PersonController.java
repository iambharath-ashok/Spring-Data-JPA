package com.guru.bharath.datajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.datajpa.model.Person;
import com.guru.bharath.datajpa.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(path="/getAll", method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@RequestMapping(path= "/getByid/{id}", method = RequestMethod.GET)
	public Person getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id);
	}
	
	@RequestMapping(path="/getByFirstName/{name}", method = RequestMethod.GET)
	public List<Person> getPersonByName(@PathVariable String name) {
		return personService.getPersonByName(name);
	}
	
	
	@RequestMapping(path="/addPerson", method= RequestMethod.POST)
	public HttpStatus addPerson(@RequestBody Person person) {
		return personService.addPerson(person)? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}
	
	
	
	@RequestMapping(path="/updatePerson", method = RequestMethod.PUT)
	public HttpStatus updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person)? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(path="/deletePersonById/{id}", method = RequestMethod.DELETE)
	public HttpStatus deletePersonById (@PathVariable Long id) {
		personService.deletePerson(id);
		return HttpStatus.OK;
	}
	
	
	
}
