package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);
    void delete(Customer customer);
    List<Customer> findByAll(String keyword);
    List<Customer> showCustomerService();
}
