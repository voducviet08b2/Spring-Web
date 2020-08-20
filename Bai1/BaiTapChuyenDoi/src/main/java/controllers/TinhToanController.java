package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TinhToanController {
    @RequestMapping(value = "/tinhtoan")
    public String tinhToan(){
        return "tinhtoan";
    }
    @RequestMapping(value="/result",method = RequestMethod.GET)
    public ModelAndView result(@RequestParam int number){
        int result =number*23000;
        ModelAndView model = new ModelAndView("/result");
        model.addObject("result",result);
        return model;
    }
}
