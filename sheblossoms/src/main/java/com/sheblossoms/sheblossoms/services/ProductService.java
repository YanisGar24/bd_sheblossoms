package com.sheblossoms.sheblossoms.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.Product;
import com.sheblossoms.sheblossoms.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productsRepository;
	
	//GET Obtener lista de products
	public List<Product> findAllProducts(){
		return productsRepository.findAll();
	}
	//GET Single Obtener un product (Id)
	public Optional<Product> findProductById(Long id){
		return productsRepository.findById(id);
	}
	
	//POST
	public Product saveProduct(Product product) {
		return productsRepository.save(product);
	}
	
	//PUT Actualizar una entidad existente 
	public Product updateProduct(Long id, Product updateProduct) {
		
		//Verificar si el producto existe 
		Optional<Product> existProduct = productsRepository.findById(id);
		if (existProduct.isPresent()) {
			Product existingProduct = existProduct.get();
		//Actualizar info 
		existingProduct.setProductName(updateProduct.getProductName());
        //existing
        return productsRepository.save(existingProduct);
		} else { 
			//Manejar en caso que no existe 
			throw new RuntimeException("Product not found with id: " + id);
		}
	}
	
	//DELETE 
	public void deleteProduct(Long id) {
		productsRepository.deleteById(id);
	}
}


