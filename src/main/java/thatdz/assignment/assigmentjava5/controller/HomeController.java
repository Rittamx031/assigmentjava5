package thatdz.assignment.assigmentjava5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("index")
    public String getHomepage(){
        return "home/index.html";
    }
}
