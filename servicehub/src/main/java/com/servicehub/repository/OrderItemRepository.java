package com.servicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicehub.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}