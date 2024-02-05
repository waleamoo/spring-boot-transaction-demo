package com.techqwerty.springboottransactiondemo.dto;

import com.techqwerty.springboottransactiondemo.entity.Order;
import com.techqwerty.springboottransactiondemo.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
