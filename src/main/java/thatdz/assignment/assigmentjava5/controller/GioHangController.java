package thatdz.assignment.assigmentjava5.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTietKey;
import thatdz.assignment.assigmentjava5.entity.GioHangViewModel;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.entity.Login;
import thatdz.assignment.assigmentjava5.entity.SignUp;
import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;
import thatdz.assignment.assigmentjava5.service.GioHangChiTietService;
import thatdz.assignment.assigmentjava5.service.GioHangService;
import thatdz.assignment.assigmentjava5.service.KhachHangService;
import thatdz.assignment.assigmentjava5.service.SanPhamService;

@Controller
public class GioHangController {
    @Autowired
    public GioHangService service;
    @Autowired
    public KhachHangService khachHangservice;
    @Autowired
    public SignUp signup;
    @Autowired
    public KhachHang khachHang;
    @Autowired
    public GioHang gioHang;
    @Autowired
    public GioHangChiTiet gioHangChiTiet;
    @Autowired
    public GioHangViewModel viewmodel;
    @Autowired
    private Login login;
    @Autowired
    public GioHangChiTietService gioHangChiTietService;
    @Autowired
    public ChiTietSanPhamService ctspService;

    @ModelAttribute("khachHang")
    public KhachHang khachHang() {
        khachHang = khachHangservice.login(login);
        return khachHang;
    }
    @GetMapping("user/cart")
    public String Cart(Model model, RedirectAttributes redirAttrs) {
        if (khachHang == null) {
            redirAttrs.addFlashAttribute("error", "Đăng Nhập để xem giỏ hàng");
            return "redirect:/thatpee/index";
        } else {
            gioHang = service.checkGioHang(khachHang);
            model.addAttribute("listGioHangChiTiet", gioHangChiTietService.getGioHangViewModel(gioHang));
            return "user/giohang.html";
        }
    }

    @PostMapping("/user/cart/updateQuantity")
    public String updateQuantity(@RequestParam("id") UUID id,
            @RequestParam("quantity") Integer quantity) {
                gioHangChiTietService.updateQuality(gioHang, id, quantity);
        return "redirect:/user/cart";
    }
    @GetMapping("/user/cart/remove")
    public String removeSP(@RequestParam("id") UUID id) {
                gioHangChiTietService.deleteGioHangChiTiet(gioHang, id);
        return "redirect:/user/cart";
    }
    @GetMapping("/user/addtocart")
    public String addToCart(@RequestParam("idsp") UUID id,RedirectAttributes redirAttrs) {
        ChiTietSanPham ctsh =  ctspService.getChiTietSanPhamById(id);
            if(khachHang == null){
                redirAttrs.addFlashAttribute("error", "Đăng Nhập để thêm sản phẩm vào giỏ !!!");
                return "redirect:/thatpee/index";
            }else{
                GioHang gh = service.checkGioHang(khachHang);
                redirAttrs.addFlashAttribute("succes", gioHangChiTietService.checkSanPhamExists(gh,ctsh));
                return "redirect:/thatpee/index";
            }
    }
}
