package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
    @GetMapping("/loginSuccess")
    public String loginSuccess(){
        return "loginSuccess";
    }
}
