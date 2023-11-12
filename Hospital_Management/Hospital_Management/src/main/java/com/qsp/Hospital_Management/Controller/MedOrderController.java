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

import com.qsp.Hospital_Management.dto.MedOrder;
import com.qsp.Hospital_Management.service.MedOrderService;
import com.qsp.Hospital_Management.util.ResponseStructure;

@RestController
@RequestMapping("/medorder")
public class MedOrderController {
	
	@Autowired
	private MedOrderService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medorder ,@RequestParam int eid ) {
		return service.saveMedOrder(medorder,eid);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@RequestParam int id) {
		return service.getMedOrderById(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id,@RequestParam int eid ,@RequestBody MedOrder medorder) {
		return service.updateMedOrder(id,eid,medorder);
	}
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> FindAllMedOrder() {
		return service.FindAllMedOrder();
	}
	
}
