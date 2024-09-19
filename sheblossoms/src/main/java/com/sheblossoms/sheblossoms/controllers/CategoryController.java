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

import com.sheblossoms.sheblossoms.models.Category;
import com.sheblossoms.sheblossoms.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	public CategoryService categoryService;
	
	//GET
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
		return categoryService.getCategoryById(id)
				.map(ResponseEntity:: ok)
				.orElse(ResponseEntity.notFound().build());	
	}
	
	//POST
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		//return categoryService.savedCategory(category);
		return categoryService.saveLoan(category); //khe?
	}
	
	//PUT
	
	
	//DELETE
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		return categoryService.getCategoryById(id)
				.map(category -> {
					categoryService.deleteCategory(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	

}
