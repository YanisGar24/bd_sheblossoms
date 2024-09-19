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

import com.sheblossoms.sheblossoms.models.Shops;
import com.sheblossoms.sheblossoms.services.ShopService;

@RestController
@RequestMapping("/api/shops")
public class ShopsController {
	@Autowired
	public ShopService shopsService;
	
	//GET
	@GetMapping
	public List<Shops> getAllShops(){
		return shopsService.findAllshops();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Shops> getShopsById(@PathVariable Long id){
		return shopsService.findShopById(id)
				.map(ResponseEntity:: ok)
				.orElse(ResponseEntity.notFound().build());	
	}
	
	//POST
	@PostMapping
	public Shops createShops(@RequestBody Shops shops) {
		return shopsService.saveShop(shops);
	}
	
	//PUT
	
	
	//DELETE
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteShops(@PathVariable Long id) {
		return shopsService.findShopById(id)
				.map(shops -> {
					shopsService.deleteShop(id);
					return ResponseEntity.ok().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}

