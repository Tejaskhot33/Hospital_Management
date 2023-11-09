package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.EncounterDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.dto.MedOrder;

@Service
public class MedOrderService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private MedOrderDao dao;

	public MedOrder saveMedOrder(MedOrder medorder, int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			medorder.setEncounter(encounter);
			return dao.saveMedOrder(medorder, eid);
		}
		return null;
	}

	public MedOrder getMedOrderById(int id) {

		return dao.getMedOrderById(id);
	}

	public MedOrder deleteMedOrder(int id) {

		return dao.deleteMedOrder(id);
	}

	public MedOrder updateMedOrder(int id, int eid, MedOrder medorder) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		if (encounter != null) {
			medorder.setEncounter(encounter);
			return dao.updateMedOrder(medorder, id);
		}
		return null;
		
	}

	public List<MedOrder> FindAllMedOrder() {

		return dao.FindAllMedOrder();
	}

}
