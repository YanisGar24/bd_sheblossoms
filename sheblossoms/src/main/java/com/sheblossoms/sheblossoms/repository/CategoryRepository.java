package com.sheblossoms.sheblossoms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheblossoms.sheblossoms.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
