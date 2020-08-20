package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TinhToanController {
    @RequestMapping(value = "/tinhtoan")
    public String tinhToan(){

        return "tinhtoan";
    }
    @RequestMapping(value="/result",method = RequestMethod.GET)
    public ModelAndView result(@RequestParam String keyword){
        Map<String,String> list=new HashMap<>();
        list.put("hello","xin chào");
        list.put("goodbye","tạm biệt");
        String result="";
        if(list.containsKey(keyword)){
            result=list.get(keyword);
        }
        ModelAndView model = new ModelAndView("/result");
        model.addObject("result",result);
        return model;
    }
}
