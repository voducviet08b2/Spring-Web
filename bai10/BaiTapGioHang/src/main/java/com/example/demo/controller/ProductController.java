package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setup(){

        return new Cart();
    }

    @GetMapping("/")
    public String showProduct(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("cart/{id}")
    public String showCart(@ModelAttribute("cart") Cart cart, Model model, @PathVariable Long id){
        Product product=productService.findById(id);
        cart.add(product);

        Map<Product,Integer> productList=cart.findAll();
        model.addAttribute("productList",productList);
        return "cart";
    }
    @GetMapping("/sub/{id}")
    public String subCart(@ModelAttribute("cart") Cart cart, Model model, @PathVariable Long id){
        Product product=productService.findById(id);
        cart.sub(product);
        Map<Product,Integer> productList=cart.findAll();
        model.addAttribute("productList",productList);
        return "cart";
    }
}
