package com.servicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicehub.model.ServicePricing;
import com.servicehub.model.ClothItem;
import com.servicehub.model.ServiceType;

public interface ServicePricingRepository extends JpaRepository<ServicePricing, Long> {

    ServicePricing findByClothItemAndServiceType(ClothItem clothItem, ServiceType serviceType);

}