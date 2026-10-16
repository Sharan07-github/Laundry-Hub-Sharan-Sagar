package com.servicehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicehub.model.Dhobi;
import com.servicehub.repository.DhobiRepository;

@Service
public class DhobiService {

    @Autowired
    private DhobiRepository dhobiRepository;

    public Dhobi addDhobi(Dhobi dhobi) {
        return dhobiRepository.save(dhobi);
    }

    public List<Dhobi> getAllDhobis() {
        return dhobiRepository.findAll();
    }

    public List<Dhobi> getDhobisByCity(String city) {
        return dhobiRepository.findByCity(city);
    }

    public void deleteDhobi(Long id) {
        dhobiRepository.deleteById(id);
    }
}