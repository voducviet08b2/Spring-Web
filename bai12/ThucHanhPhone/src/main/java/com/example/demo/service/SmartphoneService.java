package com.example.demo.service;

import com.example.demo.model.Smartphone;

import java.util.List;

public interface SmartphoneService {
    List<Smartphone> findAll();
    Smartphone save(Smartphone phone);
    List<Smartphone> findByModel(String keyword);

}
