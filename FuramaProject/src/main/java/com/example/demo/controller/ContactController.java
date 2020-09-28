package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @GetMapping("/contact")
    public String createContact(Model model){
        model.addAttribute("customerList",customerRepository.findAll());
        model.addAttribute("employeeList",employeeRepository.findAll());
        model.addAttribute("serviceList",serviceRepository.findAll());
        model.addAttribute("contact",new Contact());
        return "contact/create";
    }
    @PostMapping("/contact")
    public String saveContact(Model model, @ModelAttribute Contact contact){
        contactRepository.save(contact);
        return "index";
    }
}
