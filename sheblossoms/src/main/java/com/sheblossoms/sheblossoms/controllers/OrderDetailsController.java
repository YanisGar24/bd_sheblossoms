package com.sheblossoms.sheblossoms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheblossoms.sheblossoms.models.OrderDetails;
import com.sheblossoms.sheblossoms.models.OrderDetails;
import com.sheblossoms.sheblossoms.services.OrderDetailsService;

@RestController
@RequestMapping("/api/OrderDetails")

public class OrderDetailsController {
	@Autowired
	private OrderDetailsService OrderDetailsService;
	
	// GET
	@GetMapping
	public List<OrderDetails> getAllOrderDetails() {
		return OrderDetailsService.getAllOrderDetails();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDetails> getOrderDetailsById(@PathVariable("id") Long id) {
		return OrderDetailsService.getOrderDetailsById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public OrderDetails createOrderDetails(@RequestBody  OrderDetails  OrderDetails) {
		return OrderDetailsService.saveOrderDetails(OrderDetails);
	}
	
	// PUT
	///////////
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrderDetails(@PathVariable("id") Long id) {
		return OrderDetailsService.getOrderDetailsById(id)
				.map(OrderDetails -> {
					OrderDetailsService.deleteOrderDetails(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
