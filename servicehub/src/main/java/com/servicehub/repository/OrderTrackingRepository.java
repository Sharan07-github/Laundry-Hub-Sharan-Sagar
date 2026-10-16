package com.servicehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicehub.model.OrderTracking;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Long> {

    List<OrderTracking> findByOrderId(Long orderId);

}