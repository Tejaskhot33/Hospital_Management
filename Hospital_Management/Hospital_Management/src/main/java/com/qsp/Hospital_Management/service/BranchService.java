package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(int hid, int aid, Branch branch) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Hospital hospital = hospitalDao.getHospitalById(hid);
		Address address = addressDao.getAddressById(aid);
		if (hospital != null && address != null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			structure.setMessage("Branch Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		}
		return null;

	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch = dao.getBranchById(id);
		if (branch != null) {
			structure.setMessage("Branch Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch = dao.deleteBranch(id);
		if (branch != null) {
			structure.setMessage("Id Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch, int hid, int aid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch2 = dao.updateBranch(branch, id);
		Hospital hospital = hospitalDao.getHospitalById(hid);
		Address address = addressDao.getAddressById(aid);
		if (hospital != null && address != null) {
			branch.setAddress(address);
			branch.setHospital(hospital);
			structure.setMessage("Branch Update Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found Exception");
		}

	}

	public ResponseEntity<ResponseStructure<List<Branch>>> findAll() {
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		List<Branch> branch = dao.findAll();
		if (branch != null) {
			responseStructure.setMessage("All Data Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoDataFound("No Data Found");
		}
	}

}
