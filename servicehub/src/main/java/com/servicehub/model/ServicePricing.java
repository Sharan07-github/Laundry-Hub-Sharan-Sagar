package com.servicehub.model;

import jakarta.persistence.*;

@Entity
@Table(name="service_pricing")
public class ServicePricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cloth_item_id")
    private ClothItem clothItem;

    @ManyToOne
    @JoinColumn(name="service_type_id")
    private ServiceType serviceType;

    private double price;

    public ServicePricing() {}

    public Long getId() {
        return id;
    }

    public ClothItem getClothItem() {
        return clothItem;
    }

    public void setClothItem(ClothItem clothItem) {
        this.clothItem = clothItem;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}