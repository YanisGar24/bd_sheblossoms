package com.sheblossoms.sheblossoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.Category;
import com.sheblossoms.sheblossoms.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public Category saveLoan(Category category) {
		return categoryRepository.save(category);
	}

    public void deleteCategory(Long id) {
    	categoryRepository.deleteById(id);
    }
}