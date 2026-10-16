package com.servicehub.model;

import jakarta.persistence.*;

@Entity
@Table(name="cloth_items")
public class ClothItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String category;

    public ClothItem() {}

    public ClothItem(String itemName, String category) {
        this.itemName = itemName;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}