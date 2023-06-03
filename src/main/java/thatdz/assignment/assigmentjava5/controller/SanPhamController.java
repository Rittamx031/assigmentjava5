package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.SanPham;
import thatdz.assignment.assigmentjava5.service.SanPhamService;

/**
 * SanPhamController
 */
@Controller
@RequestMapping("sanpham")
public class SanPhamController {
    @Autowired
    public SanPhamService service;
    @GetMapping("index")
    public String getMethodName() {
        for (SanPham entity : service.getSanPhams()) {
            System.out.println(entity.toString());
        }
        return "home/index.html";
    }
}