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

import com.qsp.Hospital_Management.dto.Hospital;
import com.qsp.Hospital_Management.service.HospitalService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@ApiOperation(notes = "This API is used to find the Hospital datails from database", value = "Find Hospital API")
	@ApiResponses(value = {@ApiResponse(code = 302, message = "Data Found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		return service.deleteHospital(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}

	@GetMapping("/email")
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(@RequestParam String email) {
		return service.getHospitalByEmail(email);
	}

	@GetMapping("/findAll")
	public List<Hospital> getAllHospital() {
		return service.getAllHospital();
	}

}
