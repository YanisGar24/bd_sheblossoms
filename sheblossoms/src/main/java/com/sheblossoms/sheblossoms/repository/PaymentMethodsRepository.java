package com.sheblossoms.sheblossoms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sheblossoms.sheblossoms.models.PaymentMethods;



@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Long> {
}
