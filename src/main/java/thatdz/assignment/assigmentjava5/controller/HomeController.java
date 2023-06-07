package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;
import thatdz.assignment.assigmentjava5.service.DongSPService;
import thatdz.assignment.assigmentjava5.service.NhanVienService;

@Controller
public class HomeController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private DongSPService dongSPService;
    @Autowired
    private GioHangController gioHangController;
    @Autowired
    private GioHangChiTietController gioHangChiTietController;
    @Autowired
    private NhanVienService nhanVienService;
    
    @GetMapping("manager/home")
    public String getHomepage(){
        return "home/index.html";
    }
    @GetMapping("shoppage")
    public String getShoppage(){
        return "shoppage/thatpee.html";
    }
    
}
