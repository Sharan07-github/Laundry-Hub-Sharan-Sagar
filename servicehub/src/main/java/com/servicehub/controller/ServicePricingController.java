package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.ServicePricing;
import com.servicehub.service.ServicePricingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pricing")
public class ServicePricingController {

    @Autowired
    private ServicePricingService pricingService;

    @PostMapping("/add")
    public ServicePricing addPricing(@RequestBody ServicePricing pricing) {
        return pricingService.addPricing(pricing);
    }

    @GetMapping("/all")
    public List<ServicePricing> getAllPricing() {
        return pricingService.getAllPricing();
    }
}