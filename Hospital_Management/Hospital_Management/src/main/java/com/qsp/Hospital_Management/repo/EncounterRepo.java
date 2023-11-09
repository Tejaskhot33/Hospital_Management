package com.qsp.Hospital_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}
