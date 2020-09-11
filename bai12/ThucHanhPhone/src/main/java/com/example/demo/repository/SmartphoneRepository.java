package com.example.demo.repository;

import com.example.demo.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Long> {
    List<Smartphone> findByModel(String keyword);
}
