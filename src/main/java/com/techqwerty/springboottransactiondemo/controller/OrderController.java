package com.techqwerty.springboottransactiondemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techqwerty.springboottransactiondemo.dto.OrderRequest;
import com.techqwerty.springboottransactiondemo.dto.OrderResponse;
import com.techqwerty.springboottransactiondemo.service.OrderService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
