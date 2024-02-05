package com.techqwerty.springboottransactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.springboottransactiondemo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    
}
