package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import thatdz.assignment.assigmentjava5.entity.ChucVu;
import thatdz.assignment.assigmentjava5.service.ChucVuService;


@Controller
@RequestMapping("chucvu")
public class ChucVuController {
    @Autowired
    private ChucVuService service;
    @GetMapping("index")
    public String getindexpage() {
        java.util.List<ChucVu> list = service.getChucVus();
        for (ChucVu chucVu : list) {
            System.out.println(chucVu.toString());
        }
        return "home/index.html";
    }
    
}
