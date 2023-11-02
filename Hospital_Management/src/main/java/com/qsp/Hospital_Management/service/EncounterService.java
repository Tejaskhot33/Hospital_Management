package com.qsp.Hospital_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.PersonDao;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.Person;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao dao;
	@Autowired
	private PersonDao persondao;
	@Autowired
	private BranchDao branchdao;

	public Encounter saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = persondao.getPersonById(pid);
		Branch branch = branchdao.getBranchById(bid);
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setBranches(list);
			return dao.saveEncounter(encounter);

		} else {
			return null;
		}
	}

	public Encounter getEncounterById(int id) {
		return dao.getEncounterById(id);

	}

	public Encounter deleteEncounter(int id) {
		return dao.deleteEncounter(id);
		
	}

	public Encounter updateEncounter(Encounter encounter, int id, int pid, int bid) {
		Person person = persondao.getPersonById(pid);
		Branch branch = branchdao.getBranchById(bid);
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			encounter.setBranches(list);
			return dao.updateEncounter(id,encounter);
			
		}
		return null;
	}
}
