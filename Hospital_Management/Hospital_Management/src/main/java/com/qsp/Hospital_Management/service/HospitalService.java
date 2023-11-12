package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.exception.EmailNotFound;
//import com.qsp.Hospital_Management.exception.HospitalIdNotFound;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.PinCodeNotFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setMessage("hospital created");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveHospital(hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setMessage("Hospital found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Hospital With given id not found ");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital != null) {
			responseStructure.setMessage("Hospital deleted successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dao.deleteHospital(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital hospital1 = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital1 != null) {
			structure.setMessage("Hospital updated successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.updateHospital(id, hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		}else {
			throw new IdNotFound("Id Not Found");
			
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(String email) {
		Hospital hospital = dao.getHospitalByEmail(email);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setMessage("Hospital updated successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getHospitalByEmail(email));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFound("Email Not Found");
		}

	}

	public List<Hospital> getAllHospital() {

		return dao.getAllHospital();
	}

}
