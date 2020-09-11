package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String keyword,Pageable pageable);
    Page<Customer> findAllByNameContainingAndProvince_NameContaining(String name,String nameProvince,Pageable pageable);
    @Query(
            value = "SELECT * FROM Customer c WHERE c.id_province = ?1",
            nativeQuery = true)
    List<Customer> findAllCusByPro(Long id);


}
