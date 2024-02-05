package com.techqwerty.springboottransactiondemo.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techqwerty.springboottransactiondemo.dto.OrderRequest;
import com.techqwerty.springboottransactiondemo.dto.OrderResponse;
import com.techqwerty.springboottransactiondemo.entity.Order;
import com.techqwerty.springboottransactiondemo.entity.Payment;
import com.techqwerty.springboottransactiondemo.exception.PaymentException;
import com.techqwerty.springboottransactiondemo.repository.OrderRepository;
import com.techqwerty.springboottransactiondemo.repository.PaymentRepository;
import com.techqwerty.springboottransactiondemo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService  {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    // whenever a single constructor exist for the Service class, Spring injects the services automatically 
    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    @Transactional 
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        // save the order details
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        // save the payment details
        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse; 
    }
    
}
