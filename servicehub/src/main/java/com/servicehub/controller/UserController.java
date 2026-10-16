package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.User;
import com.servicehub.model.Order;
import com.servicehub.model.OrderTracking;
import com.servicehub.service.UserService;
import com.servicehub.service.OrderService;
import com.servicehub.service.OrderTrackingService;
import com.servicehub.util.InvoiceGenerator;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTrackingService trackingService;

    // Register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userService.loginUser(user.getEmail(), user.getPassword());

    }

    // Get all users
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update user
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }

    // Get all orders of a user
    @GetMapping("/orders/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }

    // Get order tracking for an order
    @GetMapping("/order/tracking/{orderId}")
    public List<OrderTracking> getOrderTracking(@PathVariable Long orderId) {
        return trackingService.getTrackingByOrder(orderId);
    }

    // Download invoice for an order
    @GetMapping("/invoice/{orderId}")
    public ResponseEntity<byte[]> downloadInvoice(@PathVariable Long orderId) {

        Order order = orderService.getOrderById(orderId);

        if(order == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] pdf = InvoiceGenerator.generateInvoice(order);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=invoice.pdf")
                .body(pdf);
    }
}