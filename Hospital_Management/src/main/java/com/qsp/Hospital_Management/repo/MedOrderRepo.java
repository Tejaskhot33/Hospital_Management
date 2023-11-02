package com.qsp.Hospital_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{

}
