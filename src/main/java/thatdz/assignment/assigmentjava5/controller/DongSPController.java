package thatdz.assignment.assigmentjava5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.service.DongSPService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("dongsp")
public class DongSPController {
    @Autowired 
    private DongSPService service;
    @GetMapping("index")
    public String getMethodName() {
        List<DongSP> list = service.getDongSPs();
        for (DongSP dongSP : list) {
            System.out.println(dongSP.toString());
        }
        return "home/index.html";
    }
    
}
