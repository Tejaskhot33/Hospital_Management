package com.qsp.Hospital_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo  repo;
	
	public Address saveAddress(Address address) {

		return repo.save(address);
	}

	public Address getAddressById(int id) {
		Optional<Address> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
		
		
	}

	public Address deleteAddress(int id) {
		Optional<Address> optional =repo.findById(id);
		if(optional.isPresent())
		{
			 repo.deleteById(id);
			 return optional.get();
		}
		return null;
	}

	public Address updateAddress(int id, Address address) {
			Optional<Address> optional=repo.findById(id);
			if(optional.isPresent())
			{
				address.setId(id);
				return repo.save(address);
			}
		return null;
	}

	public Address getAddressByPincode(int pincode) {
		
		
		return repo.findAddressByPincode(pincode);
	}

	public List<Address> findAll() {

		return repo.findAll();
	}

}
