package com.qsp.Hospital_Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Hospital_Management.dao.AddressDao;
import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.exception.IdNotFound;
import com.qsp.Hospital_Management.exception.NoDataFound;
import com.qsp.Hospital_Management.exception.PinCodeNotFound;
import com.qsp.Hospital_Management.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		Address address2 = dao.saveAddress(address);
		if (address != null) {
			structure.setMessage("Address created");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(address2);

		}
		return null;

	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		Address address = dao.getAddressById(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		if (address != null) {
			responseStructure.setMessage("Address found successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address = dao.deleteAddress(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		if (address != null) {
			responseStructure.setMessage("Address deleted successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address address1 = dao.updateAddress(id, address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		if (address1 != null) {
			responseStructure.setMessage("Address Updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address1);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressByPincode(int pincode) {
		Address address = dao.getAddressByPincode(pincode);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		if (address != null) {
			responseStructure.setMessage("Address Found by pincode successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PinCodeNotFound("Hospital With given Pincode not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Address>>> findAll() {
		List<Address> address = dao.findAll();
		ResponseStructure<List<Address>> responseStructure = new ResponseStructure<>();

		if (address != null) {
			responseStructure.setMessage("All Data Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoDataFound(" No Data Found");

		}

	}

}
