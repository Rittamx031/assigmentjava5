package thatdz.assignment.assigmentjava5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.service.HoaDonService;


@Controller
@RequestMapping("hoadon")
public class HoaDonController {
    @Autowired
    public HoaDonService service;
    @GetMapping("index")
    public String getMethodName() {
        List<HoaDon> list =service.getHoaDons();
        for (HoaDon hoaDon : list) {
            System.out.println(hoaDon.toString());
        }

        return "home/index.html";
    }
    
}
