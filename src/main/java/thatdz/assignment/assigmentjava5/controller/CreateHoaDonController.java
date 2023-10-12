package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thatdz.assignment.assigmentjava5.dto.request.HoaDonRequest;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.service.HoaDonChiTietService;
import thatdz.assignment.assigmentjava5.service.HoaDonService;
import thatdz.assignment.assigmentjava5.service.SanPhamOrderService;

@Controller
@RequestMapping("manager/createhoadon")
public class CreateHoaDonController {
  @Autowired
  private SanPhamOrderService service;
  private HoaDon hoaDon;
  @Autowired
  private HoaDonService hoaDonService;
  @Autowired
  private HoaDonChiTietService hdctservice;

  @Autowired
  HoaDonRequest hoaDonRequest;
  public int rowcount = 10;
  public int[] pagenumbers;
  public String sortBy = "sanPham.ten";
  public String searchtxt = "";
  public boolean sortDir = true;
  public int pageno = 0;
  public int totalpage = 0;

  @ModelAttribute("hoaDonRequest")
  public HoaDonRequest getHoaDonRequest() {
    return hoaDonRequest;
  }

  // panigation and sort
  @GetMapping("/getcountrow")
  public String getCountRow(Model model, @RequestParam("selectedValue") String selectedValue) {
    System.out.println(selectedValue);
    rowcount = Integer.parseInt(selectedValue);
    pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
    this.pageno = 1;
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, 1, rowcount, sortBy, sortDir);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    return "manager/hoadon/createhoadon.html"; // Redirect back to the form page
  }

  @GetMapping("/search")
  public String getSeacrResult(Model model, @RequestParam("searchtxt") String searchtxt) {
    System.out.println(searchtxt);
    this.searchtxt = searchtxt;
    List<ChiTietSanPham> ctsts = service.getChiTietSanPhams(searchtxt, PageRequest.of(0, 20));
    ctsts.forEach((ctsp) -> {
      System.out.println(ctsp.getSanPham().getTen());
    });
    pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
    this.pageno = 1;
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, 1, rowcount, sortBy, sortDir);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    return "manager/hoadon/createhoadon.html"; // Redirect back to the form page
  }

  @GetMapping("sort")
  public String getPageSort(Model model, @RequestParam("sortBy") String sortby,
      @RequestParam("sortDir") boolean sordir) {
    this.sortBy = sortby;
    this.sortDir = sordir;
    this.pageno = 1;
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, this.pageno, rowcount, this.sortBy, this.sortDir);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
    model.addAttribute("list", list);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    return "manager/hoadon/createhoadon.html";
  }

  @GetMapping("/page")
  public String getPageNo(Model model, @RequestParam("pageno") int pageno) {
    if (pageno <= 1) {
      this.pageno = 1;
      pageno = 1;
    }
    this.pageno = pageno;
    System.out.println(pageno);
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, this.pageno, rowcount, sortBy, sortDir);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    model.addAttribute("totalpage", totalpage);
    pagenumbers = service.getPanigation(searchtxt, rowcount, this.pageno);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", this.pageno);
    model.addAttribute("list", list);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    return "manager/hoadon/createhoadon.html";
  }

  @GetMapping({ "index", "" })
  public String getHoaDonIndexpages(Model model) {
    this.pageno = 1;
    this.searchtxt = "";
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, this.pageno, rowcount, sortBy, sortDir);
    pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    hoaDonRequest = new HoaDonRequest();
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("searchtxt", searchtxt);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    return "manager/hoadon/createhoadon.html";
  }

  // end panigation

  @PostMapping("updateQuantity")
  public String updateQuantity(@RequestParam("id") UUID id,
      @RequestParam("quantity") Integer quantity) {
    hdctservice.updateSanPhamInHoaDon(quantity, hoaDon.getId(), id);
    return "redirect:/manager/createhoadon";
  }

  @GetMapping("addproduct/{idsanpham}")
  public String addProduct(@PathVariable("idsanpham") UUID id) {
    hdctservice.addSanPhamInHoaDon(hoaDon.getId(), id);
    return "redirect:/manager/createhoadon";
  }

  @PostMapping("createorder")
  public String createOrder(Model model) {
    return "";
  }

  @GetMapping(value = "payMethod")
  public String getMethodName(Model model) {
    hoaDonService.thanhToan(hoaDon.getId());
    model.addAttribute("orderdetail", hoaDonService.getOrderDetail(hoaDon.getId()));
    return "user/orderdetail.html";
  }

}
