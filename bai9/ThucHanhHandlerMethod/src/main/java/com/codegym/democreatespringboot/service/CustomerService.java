package com.codegym.democreatespringboot.service;


import com.codegym.democreatespringboot.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

}