package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.model.Rent;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.RentRepository;
import com.example.demo.service.BookService;
import com.example.demo.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
  @Autowired
    private RentRepository rentRepository;


    @Override
    public Rent findById(Long id) {
      return rentRepository.findById(id).orElse(null);
    }

  @Override
  public void save(Rent rent) {
    rentRepository.save(rent);
  }

  @Override
  public Rent findRentByCoderentNative(int code) {
    return rentRepository.findRentByCoderentNative(code);
  }

  @Override
  public void delete(Rent rent) {
    rentRepository.delete(rent);
  }

}
