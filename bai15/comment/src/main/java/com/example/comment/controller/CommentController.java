package com.example.comment.controller;

import com.example.comment.model.Comment;
import com.example.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public String listComment(Model model){
        List<Comment> commentList=commentService.findAll();
        model.addAttribute("commentList",commentList);
        return "comment/list";
    }
    @GetMapping("/create-comment")
    public String createComment(Model model){
        model.addAttribute("comment",new Comment());
        return "comment/create";
    }
    @PostMapping("/create-comment")
    public String saveComment(@ModelAttribute Comment comment,Model model){
        commentService.save(comment);
        List<Comment> commentList=commentService.findAll();
        model.addAttribute("commentList",commentList);
        model.addAttribute("message", "New comment created successfully");
        return "comment/list";
    }
    @GetMapping("/delete-comment/{id}")
    public String deleteComment(@PathVariable Long id, Model model){
        Comment comment=commentService.findById(id);
        commentService.delete(comment);
        List<Comment> commentList=commentService.findAll();
        model.addAttribute("commentList",commentList);
        return "comment/list";
    }
    @GetMapping("/edit-comment/{id}")
    public String editComment(@PathVariable Long id, Model model){
        Comment comment=commentService.findById(id);
        model.addAttribute("comment",comment);
        return "comment/edit";
    }
    @PostMapping("/edit-comment")
    public ModelAndView updateComment(@ModelAttribute Comment comment){
        ModelAndView modelAndView=new ModelAndView("comment/list");
        commentService.save(comment);
        List<Comment> commentList=commentService.findAll();
        modelAndView.addObject("commentList",commentList);
        return modelAndView;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "comment/loginPage";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "comment/logoutSuccessfulPage";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = com.example.thuchanhsudungspringsecurity.util.WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "comment/adminPage";
    }
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = com.example.thuchanhsudungspringsecurity.util.WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "comment/userInfoPage";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = com.example.thuchanhsudungspringsecurity.util.WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "comment/403Page";
    }
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "comment/welcomePage";
    }
}
