package com.qsp.Hospital_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dto.Address;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao; 
	
	public Address saveAddress(Address address) {

		return dao.saveAddress(address);
	}

	public Address getAddressById(int id) {

		return dao.getAddressById(id);
	}

	public Address deleteAddress(int id) {

		return dao.deleteAddress(id);
	}

	public Address updateAddress(int id, Address address) {

		return dao.updateAddress(id , address);
	}

	public Address getAddressByPincode(int pincode) {

		return dao.getAddressByPincode(pincode);
	}

}
