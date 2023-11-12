package com.qsp.Hospital_Management.service;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.IdentNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Person;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person person2 = dao.savePerson(person);
		if (person2 != null) {
			structure.setMessage("Person Save Succeesfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(person2);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.CREATED);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person person = dao.getPersonById(id);
		if (person != null) {
			structure.setMessage("Id Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.FOUND);
		}

		else {
			throw new IdNotFound("Id Not Found Exception");

		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person person = dao.deletePerson(id);
		if (person != null) {
			structure.setMessage("Id deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		}

		else {
			throw new IdNotFound("Id Not Found Exception");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int id, Person person) {
		ResponseStructure<Person> structure = new ResponseStructure<>();
		Person person2 = dao.updatePerson(id, person);

		if (person2 != null) {
			structure.setMessage("Id Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<List<Person>>> findAll() {
		ResponseStructure<List<Person>> structure = new ResponseStructure<>();
		List<Person> person = dao.findAll();
		if (person != null) {
			structure.setMessage("Data Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<List<Person>>>(structure, HttpStatus.FOUND);
		}
		else
		{
			throw new NoDataFound("No Data Found Exception");
		}
	}
}
