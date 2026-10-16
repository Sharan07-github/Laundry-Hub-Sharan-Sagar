package com.servicehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servicehub.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

}