package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        Page<Customer> customerList=customerRepository.findAll(pageable);
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getCustomerByNameContaining(String keyword,Pageable pageable) {
        return customerRepository.findAllByNameContaining(keyword,pageable);
    }

    @Override
    public Page<Customer> getCustomerByNameContainingAndProvince(String keyword, String keyword2, Pageable pageable) {
        return customerRepository.findAllByNameContainingAndProvince_NameContaining(keyword,keyword2,pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
