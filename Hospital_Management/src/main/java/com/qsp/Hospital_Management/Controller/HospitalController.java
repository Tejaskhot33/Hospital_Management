package com.qsp.Hospital_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.service.HospitalService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;
	@PostMapping("/hospital")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}
	
	@GetMapping("/hospital")
	public ResponseStructure<Hospital> getHospitalById(@RequestParam int id) {
		return service.getHospitalById( id);
	}
	@DeleteMapping("/hospital")
	public ResponseStructure<Hospital> deleteHospital( @RequestParam int id) {
		return service.deleteHospital(id);
	}
	@PutMapping("/hospital")
	public ResponseStructure<Hospital> updateHospital(@RequestParam int id ,  @RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}
	@GetMapping("/email")
	public Hospital getHospitalByEmail(@RequestParam String email) {
		return service.getHospitalByEmail(email);
		
	}

}
