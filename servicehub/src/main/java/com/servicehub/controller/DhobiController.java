package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.Dhobi;
import com.servicehub.model.Order;
import com.servicehub.service.DhobiService;
import com.servicehub.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dhobis")
public class DhobiController {

    @Autowired
    private DhobiService dhobiService;

    @Autowired
    private OrderService orderService;

    // Add new dhobi
    @PostMapping("/add")
    public Dhobi addDhobi(@RequestBody Dhobi dhobi) {
        return dhobiService.addDhobi(dhobi);
    }

    // Get all dhobis
    @GetMapping("/all")
    public List<Dhobi> getAllDhobis() {
        return dhobiService.getAllDhobis();
    }

    // Get dhobis by city
    @GetMapping("/city/{city}")
    public List<Dhobi> getDhobisByCity(@PathVariable String city) {
        return dhobiService.getDhobisByCity(city);
    }

    // Delete dhobi
    @DeleteMapping("/delete/{id}")
    public String deleteDhobi(@PathVariable Long id) {
        dhobiService.deleteDhobi(id);
        return "Dhobi deleted successfully";
    }

    // NEW: Get orders assigned to dhobi
    @GetMapping("/orders/{dhobiId}")
    public List<Order> getOrdersForDhobi(@PathVariable Long dhobiId) {
        return orderService.getOrdersByDhobi(dhobiId);
    }

    // NEW: Update order status
    @PutMapping("/order/status/{orderId}")
    public Order updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return orderService.updateStatus(orderId, status);
    }
}