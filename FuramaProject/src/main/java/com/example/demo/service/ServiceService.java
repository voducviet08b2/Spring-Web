package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Service;

import java.util.List;

public interface ServiceService {
    void save(Service service);
    List<Service> findAll();
    Service findById(Long id);
    void delete(Service service);
    List<Service> findByAll(String keyword);
}
