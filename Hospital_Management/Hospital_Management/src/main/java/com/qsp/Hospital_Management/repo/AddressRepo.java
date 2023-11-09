package com.qsp.Hospital_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Hospital_Management.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	Address findAddressByPincode(int pincode);

}
