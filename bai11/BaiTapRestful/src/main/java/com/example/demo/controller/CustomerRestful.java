package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CustomerRestful {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/customerrestful")
    public ResponseEntity<List<Customer>> getAllList(){
        List<Customer> customerList=customerService.findAllCustomer();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    @GetMapping("/province-restful")
    public ResponseEntity<List<Province>> getAllProvince(){
        List<Province> provinceList=provinceService.getAllProvince();
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }
    @GetMapping("/province-restful/{id}")
    public ResponseEntity<List<Customer>> getCusByPro(@PathVariable Long id){
        List<Customer> customerList=customerService.findAllCusByPro(id);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
