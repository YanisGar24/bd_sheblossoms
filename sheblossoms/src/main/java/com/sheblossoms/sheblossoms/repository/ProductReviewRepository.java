package com.sheblossoms.sheblossoms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheblossoms.sheblossoms.models.ProductReviews;


@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReviews, Long> {
}
