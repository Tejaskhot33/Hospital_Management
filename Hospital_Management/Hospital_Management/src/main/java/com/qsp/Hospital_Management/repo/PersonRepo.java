package com.qsp.Hospital_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
