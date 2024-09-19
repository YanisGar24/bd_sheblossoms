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

import com.sheblossoms.sheblossoms.services.ProductService;
import com.sheblossoms.sheblossoms.models.Product;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// GET
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable("id") Long id) {
		return productService.findProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	// POST
	@PostMapping
	public Product createProduct(@RequestBody Product products) {
		return productService.saveProduct(products);
	}
	
	// PUT
	///////////
	
	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		return productService.findProductById(id)
				.map(product -> {
					productService.deleteProduct(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
