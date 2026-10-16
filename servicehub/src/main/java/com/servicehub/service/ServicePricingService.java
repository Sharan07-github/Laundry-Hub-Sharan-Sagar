package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.ServicePricing;
import com.servicehub.repository.ServicePricingRepository;

@Service
public class ServicePricingService {

    @Autowired
    private ServicePricingRepository pricingRepository;

    public ServicePricing addPricing(ServicePricing pricing) {
        return pricingRepository.save(pricing);
    }

    public List<ServicePricing> getAllPricing() {
        return pricingRepository.findAll();
    }

}