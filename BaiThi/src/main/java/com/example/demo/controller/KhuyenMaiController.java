package com.example.demo.controller;

import com.example.demo.model.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import com.example.demo.service.KhuyenMaiService;
import com.example.demo.service.KhuyenMaiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;


    @GetMapping("/")
    public String getIndex(Model model){
        List<KhuyenMai> khuyenMaiList=khuyenMaiService.findALl();
        model.addAttribute("khuyenMaiList",khuyenMaiList);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("khuyenMai",new KhuyenMai());
        return "create";

    }
    @PostMapping("/create")
    public String confirmCreate(@Validated @ModelAttribute KhuyenMai khuyenMai, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create";
        }
        khuyenMaiService.save(khuyenMai);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        khuyenMaiService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/searchSaleOff")
    public String searchSale(Model model, @RequestParam int keyword){

        List<KhuyenMai> khuyenMaiList=khuyenMaiService.findBySaleOff(keyword);
        model.addAttribute("khuyenMaiList",khuyenMaiList);
        return "index";
    }
    @GetMapping("/searchDateStart")
    public String searchDateS(Model model, @RequestParam String keyword){

        List<KhuyenMai> khuyenMaiList=khuyenMaiService.findByTimeStart(keyword);
        model.addAttribute("khuyenMaiList",khuyenMaiList);
        return "index";
    }
    @GetMapping("/searchDateEnd")
    public String searchDateE(Model model, @RequestParam String keyword){

        List<KhuyenMai> khuyenMaiList=khuyenMaiService.findByTimeEnd(keyword);
        model.addAttribute("khuyenMaiList",khuyenMaiList);
        return "index";
    }
    @GetMapping("/searchAll")
    public String searchAll(Model model,@RequestParam(defaultValue = "0") int sale,@RequestParam String date1,@RequestParam String date2){
        List<KhuyenMai> khuyenMaiList=khuyenMaiService.findBySaleOffOrTimeStartOrTimeEnd(sale,date1,date2);
        model.addAttribute("khuyenMaiList",khuyenMaiList);
        return "index";
    }
}
