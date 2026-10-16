package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.CartItem;
import com.servicehub.model.ServicePricing;
import com.servicehub.repository.CartItemRepository;
import com.servicehub.repository.ServicePricingRepository;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartRepository;

    @Autowired
    private ServicePricingRepository pricingRepository;

    public CartItem addToCart(CartItem item) {

        // Fetch price from ServicePricing table
        ServicePricing pricing = pricingRepository
                .findByClothItemAndServiceType(item.getClothItem(), item.getServiceType());

        if (pricing != null) {
            item.setPrice(pricing.getPrice());
        }

        return cartRepository.save(item);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeItem(Long id) {
        cartRepository.deleteById(id);
    }
}