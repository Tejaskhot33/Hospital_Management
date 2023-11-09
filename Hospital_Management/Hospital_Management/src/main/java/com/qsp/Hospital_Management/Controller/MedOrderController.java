package com.qsp.Hospital_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/medorder")
public class MedOrderController {
	
	@Autowired
	private MedOrderService service;
	
	@PostMapping
	public MedOrder saveMedOrder(@RequestBody MedOrder medorder ,@RequestParam int eid ) {
		return service.saveMedOrder(medorder,eid);
	}
	@GetMapping
	public MedOrder getMedOrderById(@RequestParam int id) {
		return service.getMedOrderById(id);
	}
	@DeleteMapping
	public MedOrder deleteMedOrder(@RequestParam int id) {
		return service.deleteMedOrder(id);
	}
	@PutMapping
	public MedOrder updateMedOrder(@RequestParam int id,@RequestParam int eid ,@RequestBody MedOrder medorder) {
		return service.updateMedOrder(id,eid,medorder);
	}
	@GetMapping("/findall")
	public List<MedOrder> FindAllMedOrder() {
		return service.FindAllMedOrder();
	}
	
}
