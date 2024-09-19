package com.sheblossoms.sheblossoms.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.sheblossoms.sheblossoms.models.OrderDetails;




@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}

