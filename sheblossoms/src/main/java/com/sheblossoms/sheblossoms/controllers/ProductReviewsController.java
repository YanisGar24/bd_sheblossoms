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

import com.sheblossoms.sheblossoms.models.ProductReviews;
import com.sheblossoms.sheblossoms.services.ProductReviewsService;

@RestController
@RequestMapping("/api/ProductReviews")
public class ProductReviewsController {
	@Autowired
	public ProductReviewsService ProductReviewsService;
	
	// GET
	@GetMapping
	public List<ProductReviews> getAllProductReviewss() {
		return ProductReviewsService.findAllProductReviewss();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductReviews> getProductReviewsById(@PathVariable("id") Long id) {
		return ProductReviewsService.findProductReviewsById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public ProductReviews createProductReviews(@RequestBody ProductReviews ProductReviews) {
		return ProductReviewsService.saveProductReviews(ProductReviews);
	}
	
	// PUT
	///////////
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductReviews(@PathVariable("id") Long id) {
		return ProductReviewsService.findProductReviewsById(id)
				.map(ProductReviews -> {
					ProductReviewsService.deleteProductReviews(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
