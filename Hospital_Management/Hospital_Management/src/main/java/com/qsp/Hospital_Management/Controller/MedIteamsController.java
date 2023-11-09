package com.qsp.Hospital_Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Hospital_Management.dto.MedIteams;
import com.qsp.Hospital_Management.service.MedIteamService;

@RestController
@RequestMapping("/mediteams")
public class MedIteamsController {
	@Autowired
	private MedIteamService service;
	@PostMapping
	public MedIteams saveMedIteams(@RequestBody MedIteams mediteams,@RequestParam int mid) {
		return service.saveMedIteams(mediteams,mid);
		
	}
	@GetMapping
	public MedIteams getMedIteamsById(@RequestParam int id) {
		return service.getMedIteamsById(id);
	}

}
