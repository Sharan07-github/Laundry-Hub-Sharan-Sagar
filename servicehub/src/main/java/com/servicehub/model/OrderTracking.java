package com.servicehub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="order_tracking")
public class OrderTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    private String status;

    private LocalDateTime updatedTime;

    public OrderTracking() {
        this.updatedTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }
}