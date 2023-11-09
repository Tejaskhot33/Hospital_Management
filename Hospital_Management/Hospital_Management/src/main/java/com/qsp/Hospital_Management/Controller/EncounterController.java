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

import com.qsp.Hospital_Management.dto.Encounter;
import com.qsp.Hospital_Management.service.EncounterService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

	@Autowired
	private EncounterService service;
	
	@PostMapping
	public ResponseStructure<Encounter> saveEncounter(@RequestBody Encounter encounter,@RequestParam int pid ,@RequestParam int bid ) {
		return service.saveEncounter(encounter,pid,bid);
		
	}
	@GetMapping
	public ResponseStructure<Encounter> getEncounterById(@RequestParam int id) {
		return service.getEncounterById(id);
	}
	@DeleteMapping
	public ResponseStructure<Encounter> deleteEncounter(@RequestParam int id) {
		return service.deleteEncounter(id);
	}
	@PutMapping
	public ResponseStructure<Encounter> updateEncounter(@RequestParam int id , @RequestBody Encounter encounter,@RequestParam int pid ,@RequestParam int bid) {
		return service.updateEncounter(encounter,id,pid,bid);
	}
	
	
}