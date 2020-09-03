package com.example.demo.repository;


import com.example.demo.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    @Query(value = "SELECT * FROM rent r WHERE r.code_rent = ?1",
            nativeQuery = true)
    Rent findRentByCoderentNative(Integer code);
}