package com.example.demo.service.impl;

import com.example.demo.model.Service;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ServiceService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    public List<Service> findByAll(String keyword) {
        //return serviceRepository.findserviceByAll(keyword);
        return null;
    }
}
