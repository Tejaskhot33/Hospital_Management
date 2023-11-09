package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.repo.MedOrderRepo;

@Repository
public class MedOrderDao {

	@Autowired
	private MedOrderRepo repo;

	public MedOrder saveMedOrder(MedOrder medorder, int eid) {

		return repo.save(medorder);
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = repo.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;

	}

	public MedOrder deleteMedOrder(int id) {
		Optional<MedOrder> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public MedOrder updateMedOrder(MedOrder medorder, int id) {
		Optional<MedOrder> optional = repo.findById(id);
		if (optional != null) {
			medorder.setId(id);
			return repo.save(medorder);
		}
		return null;
	}

	public List<MedOrder> FindAllMedOrder() {
		
		return repo.findAll();
	}

}
