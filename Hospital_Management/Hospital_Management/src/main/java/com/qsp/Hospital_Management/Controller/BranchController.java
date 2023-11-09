package com.qsp.Hospital_Management.Controller;

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

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.service.BranchService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestParam int hid, @RequestParam int aid, @RequestBody Branch branch) {
		return service.saveBranch(hid,aid,branch);
		
	}
	@GetMapping
	public Branch getBranchById(@RequestParam int id) {
		return service.getBranchById(id);
	}
	@DeleteMapping
	public Branch deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
	}
	@PutMapping
	public Branch updateBranch(@RequestParam int id ,@RequestBody Branch branch ,@RequestParam int hid, @RequestParam int aid) {
		return service.updateBranch(id,branch,hid,aid);
	}
	

	
	
}
