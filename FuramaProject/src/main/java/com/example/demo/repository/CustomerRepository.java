package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer where name like %:keyword% or address like %:keyword% or phone like %:keyword%",nativeQuery = true)
    List<Customer> findCustomerByAll(@Param("keyword") String keyword);
    @Query(value = "select * \n" +
            "from customer c\n" +
            "join contact co \n" +
            "on c.id=co.id_customer Group By c.name;",nativeQuery = true)
    List<Customer> showCustomerService();

}
