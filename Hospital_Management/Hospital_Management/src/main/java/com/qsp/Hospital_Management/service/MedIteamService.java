package com.qsp.Hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.MedIteamsDao;
import com.qsp.Hospital_Management.dao.MedOrderDao;
import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.dto.MedOrder;

@Service
public class MedIteamService {
	@Autowired
	private MedIteamsDao dao;
	@Autowired
	private MedOrderDao medorderDao;

	public MedIteams saveMedIteams(MedIteams mediteams, int mid) {
		MedOrder medorder = medorderDao.getMedOrderById(mid);
		if (medorder != null) {
			mediteams.setMedorder(medorder);
			return dao.saveMedIteams(mediteams, mid);
		}
		return null;

	}

	public MedIteams getMedIteamsById(int id) {

		return dao.getMedIteamsById(id);
	}

}
