package com.qsp.Hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;

	public Person savePerson(Person person) {

		return dao.savePerson(person);
	}

	public Person getPersonById(int id) {

		return dao.getPersonById(id);
	}

	public Person deletePerson(int id) {

		return dao.deletePerson(id);
	}

	public Person updatePerson(int id, Person person) {

		return dao.updatePerson(id,person);
	}
}
