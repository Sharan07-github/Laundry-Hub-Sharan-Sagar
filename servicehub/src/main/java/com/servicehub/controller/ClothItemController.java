package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.ClothItem;
import com.servicehub.service.ClothItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/items")
public class ClothItemController {

    @Autowired
    private ClothItemService clothItemService;

    @PostMapping("/add")
    public ClothItem addItem(@RequestBody ClothItem item) {
        return clothItemService.addItem(item);
    }

    @GetMapping("/all")
    public List<ClothItem> getAllItems() {
        return clothItemService.getAllItems();
    }
}