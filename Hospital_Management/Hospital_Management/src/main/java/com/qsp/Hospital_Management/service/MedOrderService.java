package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class MedOrderService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medorder, int eid) {

		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			medorder.setEncounter(encounter);
			structure.setMessage("MedOrder Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveMedOrder(medorder, eid));

			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		MedOrder medorder = dao.getMedOrderById(id);
		if (medorder != null) {
			structure.setMessage("MedOrder Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(medorder);

			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		MedOrder medOrder = dao.deleteMedOrder(id);
		if (medOrder != null) {
			structure.setMessage("MedOrder Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, int eid, MedOrder medorder) {
		ResponseStructure<MedOrder> structure = new ResponseStructure<>();
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			medorder.setEncounter(encounter);
			structure.setMessage("MedOrder updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medorder);
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure, HttpStatus.CREATED);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<List<MedOrder>>> FindAllMedOrder() {
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<>();
		List<MedOrder> medOrder = dao.FindAllMedOrder();
		if (medOrder != null) {
			structure.setMessage("All Data Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medOrder);
			return new ResponseEntity<ResponseStructure<List<MedOrder>>>(structure, HttpStatus.FOUND);

		}

		else {
			throw new NoDataFound("No Data Found Exception");
		}
	}

}
