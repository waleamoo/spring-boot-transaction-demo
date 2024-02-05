package com.techqwerty.springboottransactiondemo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String orderTrackingNumber;
    public int totalQuantity;
    public BigDecimal totalPrice;
    public String status;
    @CreationTimestamp
    public LocalDateTime dateCreated;
    @UpdateTimestamp
    public LocalDateTime lastUpdated;
    public Long shoppingCartId;
}
