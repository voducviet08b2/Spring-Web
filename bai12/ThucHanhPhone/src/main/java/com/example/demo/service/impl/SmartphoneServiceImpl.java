package com.example.demo.service.impl;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.SmartphoneRepository;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {


    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public List<Smartphone> findByModel(String keyword) {
        return smartphoneRepository.findByModel(keyword);
    }




}
