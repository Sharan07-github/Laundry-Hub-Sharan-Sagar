package com.servicehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.servicehub.model.ServiceType;
import com.servicehub.service.ServiceTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping("/add")
    public ServiceType addService(@RequestBody ServiceType service) {
        return serviceTypeService.addService(service);
    }

    @GetMapping("/all")
    public List<ServiceType> getServices() {
        return serviceTypeService.getAllServices();
    }
}