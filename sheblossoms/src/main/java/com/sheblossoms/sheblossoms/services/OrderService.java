package com.sheblossoms.sheblossoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.Order;
import com.sheblossoms.sheblossoms.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

    public void deleteOrder(Long id) {
    	orderRepository.deleteById(id);
    }
}
