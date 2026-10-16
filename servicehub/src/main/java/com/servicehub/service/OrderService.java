package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.Order;
import com.servicehub.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
    
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
    
    public List<Order> getOrdersByDhobi(Long dhobiId) {
        return orderRepository.findByDhobiId(dhobiId);
    }

    public Order updateStatus(Long orderId, String status) {

        Order order = orderRepository.findById(orderId).orElse(null);

        if(order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }

        return null;
    }
}