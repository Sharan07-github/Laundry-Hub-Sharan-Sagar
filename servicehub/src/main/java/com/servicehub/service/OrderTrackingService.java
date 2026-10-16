package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.OrderTracking;
import com.servicehub.repository.OrderTrackingRepository;

@Service
public class OrderTrackingService {

    @Autowired
    private OrderTrackingRepository trackingRepository;

    public OrderTracking updateStatus(OrderTracking tracking) {
        return trackingRepository.save(tracking);
    }

    public List<OrderTracking> getTrackingByOrder(Long orderId) {
        return trackingRepository.findByOrderId(orderId);
    }
}