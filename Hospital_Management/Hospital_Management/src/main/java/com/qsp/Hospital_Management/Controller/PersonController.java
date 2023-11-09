package com.qsp.Hospital_Management.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.Person;
import com.qsp.Hospital_Management.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
	public Person savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);
	}
	@GetMapping
	public Person getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}
	@DeleteMapping
	public Person deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}
	@PutMapping
	public Person updatePerson(@RequestParam int id ,@RequestBody Person person) {
		return service.updatePerson(id,person);
	}
}
