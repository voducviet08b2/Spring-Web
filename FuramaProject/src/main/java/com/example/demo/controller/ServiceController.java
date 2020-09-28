package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.repository.RentTypeRepository;
import com.example.demo.repository.ServiceTypeRepository;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @GetMapping("/service")
    public String showList(Model model){
        List<Service> serviceList=serviceService.findAll();
        model.addAttribute("serviceList",serviceList);
        return "service/list";
    }

    @GetMapping("/create-service")
    public String viewCreate(Model model){
        model.addAttribute("rentTypeList",rentTypeRepository.findAll());
        model.addAttribute("serviceTypeList",serviceTypeRepository.findAll());
        model.addAttribute("service",new Service());
        return "service/create";
    }
    @PostMapping("/create-service")
    public String saveService(Model model, @ModelAttribute Service service){
        serviceService.save(service);
        return "redirect:/service";
    }
    @GetMapping("/edit-service/{id}")
    public String viewEdit(Model model, @PathVariable Long id){
        Service service=serviceService.findById(id);
        model.addAttribute("rentTypeList",rentTypeRepository.findAll());
        model.addAttribute("serviceTypeList",serviceTypeRepository.findAll());
        model.addAttribute("service",service);
        return "service/edit";
    }
    @GetMapping("/delete-service/{id}")
    public String deleteService(Model model, @PathVariable Long id){
        Service service=serviceService.findById(id);
        serviceService.delete(service);

        return "redirect:/service";
    }
}
