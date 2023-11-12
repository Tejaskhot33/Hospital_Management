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

import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.service.MedIteamService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/mediteams")
public class MedIteamsController {
	@Autowired
	private MedIteamService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<MedIteams>> saveMedIteams(@RequestBody MedIteams mediteams,@RequestParam int mid) {
		return service.saveMedIteams(mediteams,mid);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<MedIteams>> getMedIteamsById(@RequestParam int id) {
		return service.getMedIteamsById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<MedIteams>> updateMedIteams(@RequestParam int id , @RequestParam int mid , @RequestBody MedIteams medIteams)
	{
		return service.updateMedIteams(id,mid,medIteams);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedIteams>> deleteMedIteams(@RequestParam int id) {
		return service.deleteMedIteams(id);
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<MedIteams>>> findAll (){
		return service.findAll();	
	}
	
}
	
	