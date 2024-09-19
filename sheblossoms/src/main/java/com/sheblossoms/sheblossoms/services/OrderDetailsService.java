package com.sheblossoms.sheblossoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.OrderDetails;
import com.sheblossoms.sheblossoms.repository.OrderDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderdetailsRepository;

    public List<OrderDetails> getAllOrderDetails() {
        return orderdetailsRepository.findAll();
    }

    public Optional<OrderDetails> getOrderDetailsById(Long id) {
        return orderdetailsRepository.findById(id);
    }

    public OrderDetails createOrderDetails(OrderDetails orderdetails) {
        return orderdetailsRepository.save(orderdetails);
    }
    
    public OrderDetails saveOrderDetails(OrderDetails orderdetails) {
		return orderdetailsRepository.save(orderdetails);
	}

    public void deleteOrderDetails(Long id) {
    	orderdetailsRepository.deleteById(id);
    }
}

