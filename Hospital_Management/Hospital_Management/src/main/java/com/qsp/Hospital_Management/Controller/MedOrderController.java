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

import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.service.MedOrderService;
import com.qsp.Hospital_Management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class MedOrderController {
	
	@Autowired
	private MedOrderService service;
	@ApiOperation(notes = "This API is used to get the MedOrder details", value = "Get MedOrder API")
	@ApiResponses(value= {@ApiResponse(code =201 , message ="Data saved Successfully")})
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@Valid @RequestBody MedOrder medorder ,@RequestParam int eid ) {
		return service.saveMedOrder(medorder,eid);
	}
	@ApiOperation(notes = "This API is used to get the MedOrder details", value = "Get MedOrder API")
	@ApiResponses(value= {@ApiResponse(code =302 , message ="Data found Successfully")})
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return service.getMedOrderById(id);
	}
	@ApiOperation(notes = "This API is used to delete the MedOrder details", value = "Delete MedOrder API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data deleted Successfully")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}

	@ApiOperation(notes = "This API is used to update MedOrder details", value = "Update MedOrder API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data updated Successfully")})
	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id,@RequestParam int eid ,@RequestBody MedOrder medorder) {
		return service.updateMedOrder(id,eid,medorder);
	}
	@ApiOperation(notes = "This API is used to FindAll MedOrder details", value = "FindAll MedOrder API")
	@ApiResponses(value= {@ApiResponse(code =200 , message ="Data Found Successfully")})
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> FindAll() {
		return service.FindAll();
	}
	
}
