package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultController {
    @RequestMapping("/result")
    public String getResult(@RequestParam("tinhtoan") String tinhtoan, @RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model){
        int result=0;
        switch (tinhtoan){
            case "cong":
                result=num1+num2;
                break;
            case "tru":
                result=num1-num2;
                break;
            case "nhan":
                result=num1*num2;
                break;
            case "chia":
                result=num1/num2;
                break;
        }
        model.addAttribute("result",result);
        return "result";
    }
}
