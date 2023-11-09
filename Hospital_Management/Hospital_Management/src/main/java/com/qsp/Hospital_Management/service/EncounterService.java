package com.qsp.Hospital_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.Person;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	@Autowired
	private PersonDao persondao;
	@Autowired
	private BranchDao branchdao;

	public ResponseStructure<Encounter> saveEncounter(Encounter encounter, int pid, int bid) {
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
			return responseStructure;

		} else {
			return null;
		}
	}

	public ResponseStructure<Encounter> getEncounterById(int id) {
		Encounter encounter = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (encounter != null) {
			responseStructure.setMessage(" Encounter found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return responseStructure;
		} else {
			responseStructure.setMessage(" Encounter Not found ");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(encounter);
			return responseStructure;
		}

	}

	public ResponseStructure<Encounter> deleteEncounter(int id) {
		Encounter encounter = dao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (encounter != null) {
			responseStructure.setMessage("Encounter deleted successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.deleteEncounter(id));
			return responseStructure;
		} else {
			responseStructure.setMessage("Encounter Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(dao.deleteEncounter(id));
			return responseStructure;
		}

	}

	public ResponseStructure<Encounter> updateEncounter(Encounter encounter, int id, int pid, int bid) {
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
			return responseStructure;
		} else {
			responseStructure.setMessage("Encounter Not Updated");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(dao.updateEncounter(id, encounter));
			return responseStructure;

		}

	}
}
