package thatdz.assignment.assigmentjava5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.service.GioHangChiTietService;
@Controller
@RequestMapping("giohangchitiet")
public class GioHangChiTietController {
    @Autowired 
    private GioHangChiTietService service;
    @GetMapping("index")
    public String getMethodName() {
        List<GioHangChiTiet> list = service.getGioHangChiTiets();
        for (GioHangChiTiet entity : list) {
            System.out.println(entity.toString());
        }
        return "home/index.html";
    }
    
}
