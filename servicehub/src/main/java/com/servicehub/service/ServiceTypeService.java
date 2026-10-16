package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.ServiceType;
import com.servicehub.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    public ServiceType addService(ServiceType service) {
        return serviceTypeRepository.save(service);
    }

    public List<ServiceType> getAllServices() {
        return serviceTypeRepository.findAll();
    }

}