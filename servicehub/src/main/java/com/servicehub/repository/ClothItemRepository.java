package com.servicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicehub.model.ClothItem;

public interface ClothItemRepository extends JpaRepository<ClothItem, Long> {

}