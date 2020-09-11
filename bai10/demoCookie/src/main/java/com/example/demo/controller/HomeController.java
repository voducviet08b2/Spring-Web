package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @GetMapping("")
    public String getHome(){
        return "home";
    }
    @GetMapping("/create")
    public String createCookie(HttpServletResponse response){
        Cookie cookie=new Cookie("username","Viet");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "home";
    }
    @GetMapping("/get")
    public String getCookie(@CookieValue(name="username") String username,Model model){
        model.addAttribute("username",username);
        return "home";
    }
}
