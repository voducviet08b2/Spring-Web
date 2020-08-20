package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView getHelloPage(Model model){
      ModelAndView modelAndView=new ModelAndView("hello");
      modelAndView.addObject("student",new Student("viet",50));
      return modelAndView;
    }
}
