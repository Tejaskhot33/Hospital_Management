package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

	Hospital findHospitalByEmail(String email);

	
}
