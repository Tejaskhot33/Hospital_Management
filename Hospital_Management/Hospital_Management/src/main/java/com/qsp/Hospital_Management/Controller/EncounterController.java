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

import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.service.EncounterService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

	@Autowired
	private EncounterService service;
	@ApiOperation(notes = "This API is used to save the Encounter details", value = "Save Encounter API")
	@ApiResponses(value= {@ApiResponse(code =201 , message ="Data Save Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid ,@RequestParam int bid ) {
		return service.saveEncounter(encounter,pid,bid);
	}
	@ApiOperation(notes = "This API is used to get the Encounter details", value = "Get Encounter API")
	@ApiResponses(value= {@ApiResponse(code =302 , message ="Data found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id) {
		return service.getEncounterById(id);
	}
	@ApiOperation(notes = "This API is used to delete the Encounter details", value = "delete Encounter API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data deleted Successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@RequestParam int id) {
		return service.deleteEncounter(id);
	}
	@ApiOperation(notes = "This API is used to update the Encounter details", value = "update Encounter API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data updated Successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int id , @RequestBody Encounter encounter,@RequestParam int pid ,@RequestParam int bid) {
		return service.updateEncounter(encounter,id,pid,bid);
	}
	@ApiOperation(notes = "This API is used to findAll the Encounter details", value = "FindALL Encounter API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data found Successfully")})
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Encounter>>> findAll() {
		return service.findAll();
	}
	
	
}
