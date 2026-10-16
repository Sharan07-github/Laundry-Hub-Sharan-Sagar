package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.OrderItem;
import com.servicehub.service.OrderItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public OrderItem addItem(@RequestBody OrderItem item) {
        return orderItemService.saveOrderItem(item);
    }

    @GetMapping("/all")
    public List<OrderItem> getAllItems() {
        return orderItemService.getAllOrderItems();
    }
}