package com.sheblossoms.sheblossoms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.ProductReviews;
import com.sheblossoms.sheblossoms.repository.ProductRepository;
import com.sheblossoms.sheblossoms.repository.ProductReviewRepository;



@Service
public class ProductReviewsService {

	@Autowired
	private ProductReviewRepository ProductReviewssRepository;
	
	//GET Obtener lista de ProductReviewss
	public List<ProductReviews> findAllProductReviewss(){
		return ProductReviewssRepository.findAll();
	}
	//GET Single Obtener un ProductReviews (Id)
	public Optional<ProductReviews> findProductReviewsById(Long id){
		return ProductReviewssRepository.findById(id);
	}
	
	//POST
	public ProductReviews saveProductReviews(ProductReviews ProductReviews) {
		return ProductReviewssRepository.save(ProductReviews);
	}
	
	//PUT Actualizar una entidad existente 
	/*
	public ProductReviews updateProductReviews(Long id, ProductReviews updateProductReviews) {
		
		//Verificar si la review existe 
		Optional<ProductReviews> existProductReviews = ProductReviewssRepository.findById(id);
		
		if (existProductReviews.isPresent()) {
			ProductReviews existingProductReviews = existProductReviews.get();
		
		
		//Actualizar info 
		existingProductReviews.setName(updateProductReviews.getName()); //no existe name
        //existing
        
        return ProductReviewssRepository.save(existingProductReviews);
		} else { 
			//Manejar en caso que no existe 
			throw new RuntimeException("ProductReviews not found with id: " + id);
		}
	}
	*/
	
	//DELETE 
	public void deleteProductReviews(Long id) {
		ProductReviewssRepository.deleteById(id);
	}
}