package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService{
    Page<Customer> getAllCustomer(Pageable pageable);
    void save(Customer customer);
    Page<Customer> getCustomerByNameContaining(String keyword,Pageable pageable);
    Page<Customer> getCustomerByNameContainingAndProvince(String keyword,String keyword2,Pageable pageable);
}
