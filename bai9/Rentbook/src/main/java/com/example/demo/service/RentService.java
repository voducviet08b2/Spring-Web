package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Rent;

import java.util.List;

public interface RentService {
    Rent findById(Long id);
    void save(Rent rent);
    Rent findRentByCoderentNative(int code);
    void delete(Rent rent);
}
