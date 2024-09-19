package com.sheblossoms.sheblossoms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.Shops;
import com.sheblossoms.sheblossoms.repository.CategoryRepository;
import com.sheblossoms.sheblossoms.repository.ShopsRepository;

@Service
public class ShopService {
	@Autowired
	private ShopsRepository shopRepository;
	
	public List<Shops> findAllshops() {
		return shopRepository.findAll();
	}
	
	public Optional<Shops> findShopById(Long id) {
		return shopRepository.findById(id);
	}
	
	public Shops saveShop(Shops shop) {
		return shopRepository.save(shop);
	}
	
	// PUT
		/*	
	public Shops updateShop(Long id, Shops updateUser) {
			
	//Verificar si la tienda existe 
	Optional<Shops> existShop = shopRepository.findById(id);
				
		if (existShop.isPresent()) {
			Shops existingShop = existShop.get();		
	//Actualizar info 
		existingShop.setStore_name(updateUser.getStore_name());
		 return shopRepository.save(existingShop);
		} else { 
		//Manejar en caso que no existe 
			throw new RuntimeException("Shop not found with id: " + id);
				}
			}
	*/
	public void deleteShop(Long id) {
		shopRepository.deleteById(id);
	}
}

