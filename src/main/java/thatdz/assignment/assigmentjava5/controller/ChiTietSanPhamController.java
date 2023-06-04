package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("chitietsanpham")
public class ChiTietSanPhamController {
    @Autowired
    public ChiTietSanPhamService service;
    @GetMapping("index")
    public String getIndexPage() {
        for (ChiTietSanPham entity : service.getChiTietSanPhams()) {
            System.out.println(entity);
        }
        return "home/index.html";
    }
    
}
