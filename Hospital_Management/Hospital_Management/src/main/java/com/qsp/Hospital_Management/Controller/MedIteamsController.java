package com.qsp.Hospital_Management.Controller;

import java.util.List;

import javax.validation.Valid;

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

import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.service.MedIteamService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mediteams")
public class MedIteamsController {
	@Autowired
	private MedIteamService service;
	@ApiOperation(notes = "This API is used to save the MedIteams details", value = "Get MedIteams API")
	@ApiResponses(value= {@ApiResponse(code =201 , message ="Data saved Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<MedIteams>> saveMedIteams(@Valid @RequestBody MedIteams mediteams,@RequestParam int mid) {
		return service.saveMedIteams(mediteams,mid);
		
	}
	@ApiOperation(notes = "This API is used to get the MedIteams details", value = "Get MedIteams API")
	@ApiResponses(value= {@ApiResponse(code =302 , message ="Data found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<MedIteams>> getMedIteamsById(@RequestParam int id) {
		return service.getMedIteamsById(id);
	}
	@ApiOperation(notes = "This API is used to update the MedIteams details", value = "Update MedIteams API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data found Successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<MedIteams>> updateMedIteams(@RequestParam int id , @RequestParam int mid , @RequestBody MedIteams medIteams)
	{
		return service.updateMedIteams(id,mid,medIteams);
	}
	@ApiOperation(notes = "This API is used to delete the MedIteams details", value = "Delete")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data deleted Successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedIteams>> deleteMedIteams(@RequestParam int id) {
		return service.deleteMedIteams(id);
	}
	@ApiOperation(notes = "This API is used to findAll the MedIteams details", value = "FindAll MedIteams API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data found Successfully")})
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<MedIteams>>> findAll (){
		return service.findAll();	
	}
	
}
	
	