package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/home/tinh?oan")
    public String infor1(Model model){
        model.addAttribute("message","Hello world");
        return "tinhtoan";
    }
}
