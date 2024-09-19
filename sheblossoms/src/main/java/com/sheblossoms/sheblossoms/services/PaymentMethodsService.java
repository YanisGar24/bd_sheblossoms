package com.sheblossoms.sheblossoms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheblossoms.sheblossoms.models.PaymentMethods;
import com.sheblossoms.sheblossoms.repository.PaymentMethodsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodsService {

    @Autowired
    private PaymentMethodsRepository paymentmethodsRepository;

    public List<PaymentMethods> getAllPaymentMethods() {
        return paymentmethodsRepository.findAll();
    }

    public Optional<PaymentMethods> getPaymentMethodsById(Long id) {
        return paymentmethodsRepository.findById(id);
    }

    public PaymentMethods createPaymentMethods(PaymentMethods paymentmethods) {
        return paymentmethodsRepository.save(paymentmethods);
    }
    
    public PaymentMethods savePaymentMethods(PaymentMethods paymentmethods) {
		return paymentmethodsRepository.save(paymentmethods);
	}

    public void deletePaymentMethods(Long id) {
    	paymentmethodsRepository.deleteById(id);
    }
}
