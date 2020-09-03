package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public String showUser(Model model){
        List<User> userList=userService.findAll();
        model.addAttribute("userList",userList);
        return "list";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("create");
            return modelAndView;

        }else {
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("list");
            return modelAndView;
        }
    }
}
