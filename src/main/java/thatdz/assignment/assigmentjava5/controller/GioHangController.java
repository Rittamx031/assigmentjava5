package thatdz.assignment.assigmentjava5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.service.GioHangService;

@Controller
@RequestMapping("giohang")
public class GioHangController {
    @Autowired
    public GioHangService service;
    @GetMapping("index")
    public String getIndexPage(){
        List<GioHang> list = service.getGioHangs();
        for (GioHang gioHang : list) {
            System.out.println(gioHang.getTenNguoiNhan());
        }
        return "home/index.html";
    }
}
