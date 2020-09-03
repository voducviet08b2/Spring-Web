package com.example.comment.controller;

import com.example.comment.aop.DemoBeforeAdvice;
import com.example.comment.model.Comment;
import com.example.comment.service.CommentService;
import com.example.comment.service.ErrorInputWord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

@Controller

public class CommentController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/comment")
    public String listComment(Model model) {
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList", commentList);
        return "comment/list";
    }

    @GetMapping("/create-comment")
    public String createComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/create";
    }

    @PostMapping("/create-comment")
    public String saveComment(@ModelAttribute Comment comment, Model model) throws ErrorInputWord {
        String[] words = comment.getFeedback().split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (Pattern.matches("(fuck|sex)", words[i])) {
                throw new ErrorInputWord();
            }
        }
        commentService.save(comment);
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList", commentList);
        model.addAttribute("message", "New comment created successfully");
        return "comment/list";


    }

    @GetMapping("/delete-comment/{id}")
    public String deleteComment(@PathVariable Long id, Model model) {
        Comment comment = commentService.findById(id);
        commentService.delete(comment);
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList", commentList);
        return "comment/list";
    }

    @GetMapping("/edit-comment/{id}")
    public String editComment(@PathVariable Long id, Model model) {
        Comment comment = commentService.findById(id);
        model.addAttribute("comment", comment);
        return "comment/edit";
    }

    @PostMapping("/edit-comment")
    public ModelAndView updateComment(@ModelAttribute Comment comment) throws ErrorInputWord {
        ModelAndView modelAndView = new ModelAndView("comment/list");
        commentService.save(comment);
        List<Comment> commentList = commentService.findAll();
        modelAndView.addObject("commentList", commentList);
        return modelAndView;
    }

    @ExceptionHandler(ErrorInputWord.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("comment/error");
    }

}
