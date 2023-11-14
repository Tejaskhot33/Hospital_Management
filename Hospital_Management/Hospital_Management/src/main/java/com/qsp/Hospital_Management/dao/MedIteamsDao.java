package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.repo.MedIteamsRepo;

@Repository
public class MedIteamsDao {
	@Autowired
	private MedIteamsRepo repo;

	public MedIteams saveMedIteams(MedIteams mediteams, int mid) {

		return repo.save(mediteams);
	}

	public MedIteams getMedIteamsById(int id) {
		Optional<MedIteams> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public MedIteams deleteMedIteams(int id) {

		Optional<MedIteams> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public List<MedIteams> findAll() {

		return repo.findAll();
	}

	public MedIteams updateMedIteams(int id, MedIteams medIteams) {

		Optional<MedIteams> optional = repo.findById(id);
		if (optional.isPresent()) {
			medIteams.setId(id);
			return repo.save(medIteams);
		}
		return null;
	}

}
