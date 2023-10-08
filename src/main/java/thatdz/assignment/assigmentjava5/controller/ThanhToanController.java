package thatdz.assignment.assigmentjava5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.HoaDonChiTiet;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.service.CookieSevice;
import thatdz.assignment.assigmentjava5.service.GioHangChiTietService;
import thatdz.assignment.assigmentjava5.service.GioHangService;
import thatdz.assignment.assigmentjava5.service.HoaDonChiTietService;
import thatdz.assignment.assigmentjava5.service.HoaDonService;

@Controller
public class ThanhToanController {
  @Autowired
  GioHangService gioHangService;
  @Autowired
  GioHangChiTietService gioHangChiTietService;
  @Autowired
  KhachHang khachHang;
  @Autowired
  HoaDonService hoaDonService;
  @Autowired
  HoaDonChiTietService hoaDonChiTietService;

  @ModelAttribute("khachHang")
  public KhachHang getKhachHang() {
    return khachHang;
  }

  @Autowired
  HoaDon hoaDon;
  @Autowired
  CookieSevice cookieSevice;

  @GetMapping("/user/pay")
  public String getPayPage(Model model, RedirectAttributes redirAttrs) {
    UUID idkhacHang = UUID.fromString(cookieSevice.getValue("userid"));
    if (idkhacHang == null) {
      redirAttrs.addFlashAttribute("error", "Đăng Nhập để xem giỏ hàng");
      return "redirect:/thatpee/index";
    } else {
      List<HoaDonChiTiet> listhoadonchitet = new ArrayList<>();
      if (cookieSevice.getValue("hoadonid") == null) {
        hoaDon = hoaDonService.createHoaDone(idkhacHang);
        listhoadonchitet = hoaDonChiTietService.newHoaDon(hoaDon);
        cookieSevice.addCookie("hoadonid", hoaDon.getId().toString(), 1);
      } else {
        hoaDon = hoaDonService.getHoaDonById(UUID.fromString(cookieSevice.getValue("hoadonid")));
        if (hoaDon == null) {
          hoaDon = hoaDonService.createHoaDone(idkhacHang);
          listhoadonchitet = hoaDonChiTietService.newHoaDon(hoaDon);
          cookieSevice.addCookie("hoadonid", hoaDon.getId().toString(), 1);
        }
        listhoadonchitet = hoaDonChiTietService.getHoaDonChiTiets(hoaDon);
        model.addAttribute("totalprice", hoaDonChiTietService.getTotalPrice(hoaDon));
      }
      model.addAttribute("orderdetail", hoaDon);
      model.addAttribute("cartproducts", listhoadonchitet);
      return "user/thanhtoan.html";
    }
  }

  @GetMapping("/user/order/remove/{idproduct}")
  public String removeProductOnOrder(@PathVariable("idproduct") UUID id, RedirectAttributes redirAttrs) {
    if (khachHang == null || hoaDon == null) {
      redirAttrs.addFlashAttribute("error", "Đăng Nhập để xem giỏ hàng");
      return "redirect:/thatpee/index";
    }
    hoaDonChiTietService.deleteHoaDonChiTiet(hoaDon.getId(), id);
    return "redirect:/user/pay";
  }

  @PostMapping("/user/pay")
  public String ThanhToan(Model model, RedirectAttributes redirAttrs) {
    hoaDon = hoaDonService.getHoaDonById(UUID.fromString(cookieSevice.getValue("hoadonid")));
    if (khachHang == null || hoaDon == null) {
      redirAttrs.addFlashAttribute("error", "Đăng Nhập để xem giỏ hàng");
      return "redirect:/thatpee/index";
    } else {
      hoaDonService.thanhToan(hoaDon.getId());
      gioHangChiTietService.xoaGioHangChiTiet(hoaDonChiTietService.getListSanPhamInHoaDon(hoaDon.getId()),
          hoaDon.getKhachHang().getId());
      model.addAttribute("orderdetail", hoaDonService.getOrderDetail(hoaDon.getId()));
      cookieSevice.remove("hoadonid");
      return "user/orderdetail.html";
    }
  }

  @GetMapping("/user/shopping")
  public String GoToHomePage() {
    hoaDonService.deleteHoaDon(UUID.fromString(cookieSevice.getValue("hoadonid")));
    cookieSevice.remove("hoadonid");
    return "redirect:/thatpee/index";
  }
}
