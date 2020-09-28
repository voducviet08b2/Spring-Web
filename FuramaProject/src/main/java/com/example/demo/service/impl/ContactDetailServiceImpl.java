package com.example.demo.service.impl;

import com.example.demo.model.Contact;
import com.example.demo.model.ContactDetail;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.DetailContactRepository;
import com.example.demo.service.ContactDetailService;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ContactDetailServiceImpl implements ContactDetailService {
    @Autowired
    private DetailContactRepository detailContactRepository;

    @Override
    public void save(ContactDetail contactDetail) {
        detailContactRepository.save(contactDetail);
    }

}
