package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartController {
    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/create")
        public ModelAndView createSmart(){
        ModelAndView mav = new ModelAndView("phones/new-phone");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }
    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }
    @GetMapping("/search")
    public ModelAndView search(){
        ModelAndView mav = new ModelAndView("phones/search");

        return mav;
    }
    @RequestMapping(value = "/searchKeyword/{keyword}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

    public List<Smartphone> createSmartphone(@PathVariable String keyword) {
        return smartphoneService.findByModel(keyword);
    }
}
