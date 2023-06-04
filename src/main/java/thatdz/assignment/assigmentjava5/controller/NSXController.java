package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.NSX;
import thatdz.assignment.assigmentjava5.service.NSXService;

@Controller
@RequestMapping("nsx")
public class NSXController {
    @Autowired
    public NSXService service;
    @GetMapping("index")
    public String getMethodName() {
        for (NSX entity : service.getNSXs()) {
            System.out.println(entity.toString());
        }
        return "home/index.html";
    }
}
