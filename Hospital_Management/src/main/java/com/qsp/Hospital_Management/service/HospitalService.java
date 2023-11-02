package com.qsp.Hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseStructure<Hospital> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (structure != null) {
			structure.setMessage("hospital created");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(hospital);

		}
//		
		return structure;
	}

	public ResponseStructure<Hospital> getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			dao.deleteHospital(id);
			structure.setMessage("Hospital found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return structure;
		} else {
			structure.setMessage("Hospital Not found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(hospital);
			return structure;
		}

//		return dao.getHospitalById(id);
	}

	public ResponseStructure<Hospital> deleteHospital(int id) {
		Hospital hospital = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital != null) {
			structure.setMessage("Hospital deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return structure;
		} else {
			structure.setMessage("Hospital Not found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(hospital);
			return structure;
		}

//		return dao.deleteHospital(id);
	}

	public ResponseStructure<Hospital> updateHospital(int id, Hospital hospital) {
		Hospital hospital1 = dao.getHospitalById(id);
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		if (hospital1 != null) {
			structure.setMessage("Hospital deleted successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital1);
			return structure;
		} else {
			structure.setMessage("Hospital Not found ");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(hospital1);
			return structure;
		}

//		return dao.updateHospital(id, hospital);
	}

	public Hospital getHospitalByEmail(String email) {

		return dao.getHospitalByGmail(email);
	}

}
