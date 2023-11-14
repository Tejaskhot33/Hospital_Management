package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.MedIteamsDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class MedIteamService {
	@Autowired
	private MedIteamsDao dao;
	@Autowired
	private MedOrderDao medorderDao;

	public ResponseEntity<ResponseStructure<MedIteams>> saveMedIteams(MedIteams mediteams, int mid) {
		MedOrder medorder = medorderDao.getMedOrderById(mid);
		ResponseStructure<MedIteams> structure = new ResponseStructure<>();
		if (medorder != null) {
			mediteams.setMedorder(medorder);
			MedIteams medIteams = dao.saveMedIteams(mediteams, mid);
			structure.setMessage("MedIteams Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(mediteams);
			return new ResponseEntity<ResponseStructure<MedIteams>>(structure, HttpStatus.CREATED);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<MedIteams>> getMedIteamsById(int id) {
		MedIteams mediteams = dao.getMedIteamsById(id);
		ResponseStructure<MedIteams> structure = new ResponseStructure<>();
		if (mediteams != null) {
			structure.setMessage("MedIteams Saved successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(mediteams);
			return new ResponseEntity<ResponseStructure<MedIteams>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<MedIteams>> updateMedIteams(int id, int mid, MedIteams medIteams) {
		MedOrder medOrder = medorderDao.getMedOrderById(mid);
		ResponseStructure<MedIteams> structure = new ResponseStructure<>();
		if (medOrder != null) {
			medIteams.setMedorder(medOrder);
			MedIteams medIteams1 = dao.updateMedIteams(id, medIteams);
			structure.setMessage("MedIteams Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medIteams1);
			return new ResponseEntity<ResponseStructure<MedIteams>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<MedIteams>> deleteMedIteams(int id) {
		ResponseStructure<MedIteams> structure = new ResponseStructure<>();
		MedIteams medIteams = dao.deleteMedIteams(id);
		if (medIteams != null) {
			structure.setMessage("Id Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(medIteams);
			return new ResponseEntity<ResponseStructure<MedIteams>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<List<MedIteams>>> findAll() {
		ResponseStructure<List<MedIteams>> structure = new ResponseStructure<>();
		List<MedIteams> medIteams = dao.findAll();
		if (medIteams != null) {
			structure.setMessage("Data Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(medIteams);
			return new ResponseEntity<ResponseStructure<List<MedIteams>>>(structure,HttpStatus.FOUND);
		} else {
			throw new NoDataFound("No Data Found Exception");
		}

	}

}
