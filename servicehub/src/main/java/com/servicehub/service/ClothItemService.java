package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.ClothItem;
import com.servicehub.repository.ClothItemRepository;

@Service
public class ClothItemService {

    @Autowired
    private ClothItemRepository clothItemRepository;

    public ClothItem addItem(ClothItem item) {
        return clothItemRepository.save(item);
    }

    public List<ClothItem> getAllItems() {
        return clothItemRepository.findAll();
    }

}