package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thatdz.assignment.assigmentjava5.dto.request.Login;
import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;
import thatdz.assignment.assigmentjava5.service.DongSPService;
import thatdz.assignment.assigmentjava5.service.KhachHangService;

@Controller
@RequestMapping("thatpee")
public class HomeController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private DongSPService dongSPService;

    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private Login login;
    @Autowired
    public KhachHang khachHang;

    @ModelAttribute("listdongsp")
    public List<DongSP> getListDongSp() {
        return dongSPService.getDongSPs();
    }

    @ModelAttribute("loginable")
    public boolean loginable() {
        return login.getMa() != null && login.getPassword() != null;
    }

    @ModelAttribute("khachHang")
    public KhachHang khachHang() {
        khachHang = khachHangService.login(login);
        return khachHang;
    }

    @GetMapping("/manager/home")
    public String getHomepage() {
        return "home/index.html";
    }
    @GetMapping("dongsanpham")
    public String getSanPhamByDongSp(Model model, @RequestParam("id") UUID idDonSp) {
        model.addAttribute("listSanPham", chiTietSanPhamService.getChiTietSanPhamByDongSp(idDonSp));
        return "shoppage/thatpee.html";
    }

    @GetMapping({ "index", "dongsanpham/all" })
    public String getShoppage(Model model) {
        model.addAttribute("listSanPham", chiTietSanPhamService.getChiTietSanPhams());
        return "shoppage/thatpee.html";
    }
}
