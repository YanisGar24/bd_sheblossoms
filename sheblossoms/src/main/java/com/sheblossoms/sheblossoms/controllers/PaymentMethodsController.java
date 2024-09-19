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

import com.sheblossoms.sheblossoms.models.PaymentMethods;
import com.sheblossoms.sheblossoms.services.PaymentMethodsService;

@RestController
@RequestMapping("/api/paymentMethods")

public class PaymentMethodsController {
	
	@Autowired
	private PaymentMethodsService paymentMethodsService;
	
	// GET
	@GetMapping
	public List<PaymentMethods> getAllPaymentMethods() {
		return paymentMethodsService.getAllPaymentMethods();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentMethods> getPaymentMethodsById(@PathVariable("id") Long id) {
		return paymentMethodsService.getPaymentMethodsById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public PaymentMethods createPaymentMethods(@RequestBody PaymentMethods paymentMethods) {
		return paymentMethodsService.savePaymentMethods(paymentMethods);
	}
	
	// PUT
	///////////
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePaymentMethods(@PathVariable("id") Long id) {
		return paymentMethodsService.getPaymentMethodsById(id)
				.map(paymentMethods -> {
					paymentMethodsService.deletePaymentMethods(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
