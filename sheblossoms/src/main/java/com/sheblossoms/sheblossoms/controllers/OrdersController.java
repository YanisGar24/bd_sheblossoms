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

import com.sheblossoms.sheblossoms.models.Order;
import com.sheblossoms.sheblossoms.services.OrderService;

@RestController
@RequestMapping("/api/Order")
public class OrdersController {
	
	@Autowired
	private OrderService OrderService;
	
	// GET
	@GetMapping
	public List<Order> getAllOrder() {
		return  OrderService.getAllOrder();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
		return OrderService.getOrderById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public Order createOrder(@RequestBody Order Order) {
		return OrderService.saveOrder(Order);
	}
	
	// PUT
	///////////
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
		return OrderService.getOrderById(id)
				.map(Order -> {
					OrderService.deleteOrder(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}



}
