package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo repo;

	@PostMapping
	public Encounter saveEncounter(Encounter encounter) {

		return repo.save(encounter);
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Encounter deleteEncounter(int id) {
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Encounter updateEncounter(int id, Encounter encounter) {
		Optional<Encounter> optional = repo.findById(id);
		if (optional.isPresent()) {
			encounter.setId(id);
			return repo.save(encounter);

		}
		return null;
	}

	public List<Encounter> findAll() {
		
		return repo.findAll();
	}

}
