package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/customer")
    public ModelAndView getAllList(@PageableDefault(2) Pageable pageable){
        Page<Customer> customerList=customerService.getAllCustomer(pageable);
        if(customerList.isEmpty()){
            return new ModelAndView("customer/list","message","Không tồn tại khách hàng nào");
        }else {
            return new ModelAndView("customer/list","customerList",customerList);
        }
    }
    @GetMapping("/create-customer")
    public ModelAndView createCustomer(){
        List<Province> provinceList=provinceService.getAllProvince();
        ModelAndView modelAndView=new ModelAndView("customer/create","customer",new Customer());
        modelAndView.addObject("provinceList",provinceList);
        return modelAndView;
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message","New Customer created!!!");
        ModelAndView modelAndView=new ModelAndView("redirect:/customer");
        return modelAndView;
    }
    @GetMapping("/search")
    @ResponseBody
    public Customer find(@RequestParam Long id){
        return customerService.findById(id);
    }
//    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
//        return smartphoneService.save(smartphone);
//    }
}
