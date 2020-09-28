package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.model.ContactDetail;
import com.example.demo.repository.*;
import com.example.demo.service.ContactDetailService;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetailContactController {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Autowired
    private ContactDetailService contactDetailService;

    @GetMapping("/create-detail-contact")
    public String createContact(Model model){
        model.addAttribute("contactList",contactRepository.findAll());
        model.addAttribute("attachServiceList",attachServiceRepository.findAll());
        model.addAttribute("contactDetail",new ContactDetail());
        return "contactDetail/create";
    }
    @PostMapping("/create-detail-contact")
    public String saveContact(Model model, @ModelAttribute ContactDetail contactDetail){

        contactDetailService.save(contactDetail);
        return "index";
    }

}
