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

import com.qsp.Hospital_Management.dto.Branch;
import com.qsp.Hospital_Management.service.BranchService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService service;
	@ApiOperation(notes = "This API is used to save the Branch details", value = "Save Branch API")
	@ApiResponses(value= {@ApiResponse(code =201 , message ="Data Save Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestParam int hid, @RequestParam int aid, @RequestBody Branch branch) {
		return service.saveBranch(hid,aid,branch);
		
	}
	@ApiOperation(notes = "This API is used to get the Address details", value = "Get Address API")
	@ApiResponses(value= {@ApiResponse(code =302 , message ="Data Found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id) {
		return service.getBranchById(id);
	}
	@ApiOperation(notes = "This API is used to delete the Address details", value = "Delete Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data Deleted Successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return service.deleteBranch(id);
	}
	@ApiOperation(notes = "This API is used to update the Address details", value = "Update Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data updated Successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int id ,@RequestBody Branch branch ,@RequestParam int hid, @RequestParam int aid) {
		return service.updateBranch(id,branch,hid,aid);
	}
	@ApiOperation(notes = "This API is used to FindAll the Address details", value = "FindAll Address API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data Save Successfully")})
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAll(){
		return service.findAll();
	}

	
	
}
