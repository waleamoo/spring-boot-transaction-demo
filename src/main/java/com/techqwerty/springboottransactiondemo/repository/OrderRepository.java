package com.techqwerty.springboottransactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.springboottransactiondemo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
