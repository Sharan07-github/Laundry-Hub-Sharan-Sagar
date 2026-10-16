package com.servicehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicehub.model.Dhobi;

public interface DhobiRepository extends JpaRepository<Dhobi, Long> {

    List<Dhobi> findByCity(String city);

}