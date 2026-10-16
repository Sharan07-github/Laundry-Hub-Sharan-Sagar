package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.OrderTracking;
import com.servicehub.service.OrderTrackingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tracking")
public class OrderTrackingController {

    @Autowired
    private OrderTrackingService trackingService;

    @PostMapping("/update")
    public OrderTracking updateStatus(@RequestBody OrderTracking tracking) {
        return trackingService.updateStatus(tracking);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderTracking> getTracking(@PathVariable Long orderId) {
        return trackingService.getTrackingByOrder(orderId);
    }
}