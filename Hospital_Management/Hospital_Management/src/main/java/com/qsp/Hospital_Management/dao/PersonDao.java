package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Person;
import com.qsp.Hospital_Management.repo.PersonRepo;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepo repo;

	public Person savePerson(Person person) {

		return repo.save(person);
	}

	public Person getPersonById(int id) {

		Optional<Person> optional = repo.findById(id);
		if (optional.isPresent()) {

			return optional.get();
		}
		return null;
	}

	public Person deletePerson(int id) {
		Optional<Person> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Person updatePerson(int id, Person person) {
		Optional<Person> optional = repo.findById(id);
		{
			if (optional.isPresent()) {

				person.setId(id);
				return repo.save(person);
			}
			return null;
		}
	}

	public List<Person> findAll() {
		
		return repo.findAll(); 
	}
}
