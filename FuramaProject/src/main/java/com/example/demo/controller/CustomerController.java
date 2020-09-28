package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.repository.CustomerTypeRepository;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("arrayList")
public class CustomerController {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String getListCustomer(){
        return "index";
    }
    @ModelAttribute("arrayList")
    public List<Customer> setUpSession() {
        return new ArrayList<>();
    }


    @GetMapping("/customer")
    private String showCustomer(Model model){
        List<Customer> customerList=customerService.findAll();
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }
    @GetMapping("/create-customer")
    private String createCustomer(Model model){
        List<CustomerType> customerTypeList=customerTypeRepository.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }
    @PostMapping("/create-customer")
    private String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult,Model model, RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            return "customer/create";
        }
        customerService.save(customer);
       redirect.addFlashAttribute("message","New Customer created!!!");
        return "redirect:/create-customer";
    }


        @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@CookieValue(name="username",defaultValue = "") String username,@PathVariable Long id,HttpServletResponse response){
        Customer customer=customerService.findById(id);
        username+=":"+customer.getId()+":"+customer.getCmnd()+":";
        Cookie cookie=new Cookie("username",username);
        cookie.setMaxAge(600);
        cookie.setPath("/");
        response.addCookie(cookie);
        customerService.delete(customer);
        return "redirect:/";
    }
    @GetMapping("/get-cookie")
    public String getCookie(@CookieValue(name="username",defaultValue = "") String username,Model model){
        model.addAttribute("username",username);
        return "index";
    }


    @GetMapping("/show-session")
    public String show(@ModelAttribute("arrayList") List<Customer> customerList2,Model model){
        model.addAttribute("customerList",customerList2);
        return "indexSession";
    }
    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@ModelAttribute("arrayList") List<Customer> customerList2,@PathVariable Long id,Model model){
        Customer customer=customerService.findById(id);
        customerList2.add(customer);
        List<CustomerType> customerTypeList=customerTypeRepository.findAll();
        model.addAttribute("customerTypeList",customerTypeList);
        model.addAttribute("customer",customer);
        return "customer/edit";
    }
    @PostMapping("/edit-customer")
    public String editCustomer(@ModelAttribute Customer customer,Model model){
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword,Model model){
        List<Customer> customerList=customerService.findByAll(keyword);
        model.addAttribute("customerList",customerList);
        return "customer/list";
    }
    @GetMapping("/view-customer")
    public String viewCustomer(Model model){
        List<Customer> customerList=customerService.showCustomerService();
        model.addAttribute("customerList",customerList);

        return "customer/list-customer-contact";
    }
}
