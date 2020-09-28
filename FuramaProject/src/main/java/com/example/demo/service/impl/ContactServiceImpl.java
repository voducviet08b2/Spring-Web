package com.example.demo.service.impl;

import com.example.demo.model.Contact;
import com.example.demo.model.Service;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.ContactService;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

}
