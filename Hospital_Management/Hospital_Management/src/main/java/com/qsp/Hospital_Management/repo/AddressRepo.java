package com.qsp.Hospital_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	List<Address> findAddressByPincode(int pincode);

}
