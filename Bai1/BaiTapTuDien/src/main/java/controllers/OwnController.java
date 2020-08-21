package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OwnController {
    @GetMapping("owners/{ownedId}")
    public String findPet(@PathVariable String ownerId){
        return "tinhtoan";
    }
}
