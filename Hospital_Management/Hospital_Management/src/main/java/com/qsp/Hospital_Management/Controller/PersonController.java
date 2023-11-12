package com.qsp.Hospital_Management.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return service.getPersonById(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int id ,@RequestBody Person person) {
		return service.updatePerson(id,person);
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Person>>> findAll()
	{
		return service.findAll();
	}
}
