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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	@ApiOperation(notes = "This API is used to save the Address details", value = "Save Address API")
	@ApiResponses(value= {@ApiResponse(code =201 , message ="Data Save Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}
	@ApiOperation(notes = "This API is used to get the Address details", value = "Get Address API")
	@ApiResponses(value= {@ApiResponse(code =302 , message ="Data Found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		return service.getAddressById(id);
	}
	@ApiOperation(notes = "This API is used to delete the Address details", value = "delete Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data deleted Successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return service.deleteAddress(id);
	}
	@ApiOperation(notes = "This API is used to update the Address details", value = "update Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data updated Successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id , @RequestBody Address address) {
		return service.updateAddress(id,address);
	}
	@ApiOperation(notes = "This API is used to get the Address details", value = "Get Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data deleted Successfully")})
	@GetMapping("/pincode")
	public ResponseEntity<ResponseStructure<Address>> getAddressByPincode(@RequestParam int pincode){
		return service.getAddressByPincode(pincode);	
	}
	@ApiOperation(notes = "This API is used to FindAll the Address details", value = "FindAll Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data Found Successfully")})
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Address>>> findAll() {
		return service.findAll();
	}
	
}
