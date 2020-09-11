package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request){
        String message=messageSource.getMessage("hello",null,"default message",request.getLocale());
        String goodbye=messageSource.getMessage("goodbye",null,"default message",request.getLocale());
        model.addAttribute("goodbye",goodbye);
        model.addAttribute("message",message);
        return "index";
    }
}
