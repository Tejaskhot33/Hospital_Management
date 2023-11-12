package com.qsp.Hospital_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.Person;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	@Autowired
	private PersonDao persondao;
	@Autowired
	private BranchDao branchdao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = persondao.getPersonById(pid);
		Branch branch = branchdao.getBranchById(bid);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setBranches(list);
			responseStructure.setMessage("Encounter Saved Successfully");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(dao.saveEncounter(encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.CREATED);

		} else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		Encounter encounter = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (encounter != null) {
			responseStructure.setMessage(" Encounter found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (encounter != null) {
			responseStructure.setMessage("Encounter deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.deleteEncounter(id));
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int id, int pid, int bid) {
		Person person = persondao.getPersonById(pid);
		Branch branch = branchdao.getBranchById(bid);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setBranches(list);
			responseStructure.setMessage("Encounter Updated Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.updateEncounter(id, encounter));
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found Exception");

		}

	}

	public ResponseEntity<ResponseStructure<List<Encounter>>> findAll() {
		List<Encounter> encounter = dao.findAll();
		ResponseStructure<List<Encounter>> structure = new ResponseStructure<>();
		if (encounter != null) {
			structure.setMessage("All Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<List<Encounter>>>(structure, HttpStatus.FOUND);
		} else {
			throw new NoDataFound("No Data Found Exception");
		}
	}
}
