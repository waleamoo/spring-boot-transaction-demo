package com.techqwerty.springboottransactiondemo.service;

import com.techqwerty.springboottransactiondemo.dto.OrderRequest;
import com.techqwerty.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest OrderRequest);
}
