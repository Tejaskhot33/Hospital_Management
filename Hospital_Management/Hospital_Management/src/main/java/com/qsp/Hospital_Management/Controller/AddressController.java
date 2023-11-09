package com.qsp.Hospital_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.Address;
import com.qsp.Hospital_Management.service.AddressService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id , @RequestBody Address address) {
		return service.updateAddress(id,address);
	}
	@GetMapping("/pincode")
	public ResponseEntity<ResponseStructure<Address>> getAddressByPincode(@RequestParam int pincode){
		return service.getAddressByPincode(pincode);	
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Address>>> findAll() {
		return service.findAll();
	}
	
}
