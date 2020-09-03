package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.Rent;
import com.example.demo.service.BookService;
import com.example.demo.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private RentService rentService;

    @GetMapping("/book")
    public ModelAndView showBook(){
        ModelAndView modelAndView=new ModelAndView("book/list");
        List<Book> bookList=bookService.findAll();
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }
    @GetMapping("/rent/{id}")
    public ModelAndView rentBook(@PathVariable Long id){
        Book book=bookService.findById(id);
        Random rd=new Random();
        int codeRent=rd.nextInt(50000-10000+1)+10000;
        ModelAndView modelAndView=new ModelAndView("book/rent");
        modelAndView.addObject("rent",new Rent());
        modelAndView.addObject("codeRent",codeRent);
        modelAndView.addObject("book",book);
        return modelAndView;
    }
    @PostMapping("/rent")
    public ModelAndView apceptRent(@ModelAttribute Rent rent){
        Book book=bookService.findById(rent.getBook().getId());
        int quanity=book.getQuanity();
        book.setQuanity(--quanity);
        bookService.save(book);
        rentService.save(rent);
        ModelAndView modelAndView=new ModelAndView("redirect:/book");
        return modelAndView;
    }
    @GetMapping("/return")
    public ModelAndView returnBook(){
        return new ModelAndView("book/return");
    }
    @PostMapping("/return")
    public ModelAndView apceptReturn(@RequestParam int codeRent){
        Rent rent=rentService.findRentByCoderentNative(codeRent);
        rentService.delete(rent);
        Book book=bookService.findById(rent.getBook().getId());
        int quanity=book.getQuanity();
        book.setQuanity(++quanity);
        bookService.save(book);
        ModelAndView modelAndView=new ModelAndView("redirect:/book");
        return modelAndView;
    }
}
