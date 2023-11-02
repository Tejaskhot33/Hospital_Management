package com.qsp.Hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dao.BranchDao;
import com.qsp.Hospital_Management.dao.HospitalDao;
import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.dto.Hospital;

@Service
public class BranchService {

	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(int hid, int aid, Branch branch) {
		Hospital hospital = hospitalDao.getHospitalById(hid);
		Address address = addressDao.getAddressById(aid);
		if (hospital != null && address != null) {
			branch.setHospital(hospital);
			branch.setAddress(address);
			return dao.saveBranch(branch);
		}

		return null;
	}

	public Branch getBranchById(int id) {

		return dao.getBranchById(id);
	}

	public Branch deleteBranch(int id) {

		return dao.deleteBranch(id);
	}

	public Branch updateBranch(int id, Branch branch, int hid, int aid) {
		Hospital hospital = hospitalDao.getHospitalById(hid);
		Address address = addressDao.getAddressById(aid);
		if (hospital != null && address != null) {
			branch.setAddress(address);
			branch.setHospital(hospital);
			return dao.updateBranch(branch, id);
		}
		return null;

	}

}
