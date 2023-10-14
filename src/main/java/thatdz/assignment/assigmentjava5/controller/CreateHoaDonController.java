package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.dto.request.HoaDonRequest;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.entity.HoaDonChiTiet;
import thatdz.assignment.assigmentjava5.repository.NhanVienIRepo;
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
  private NhanVienIRepo nhanVienRepo;
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
    model.addAttribute("listhdc", service.getHoaDonChos());
    model.addAttribute("totalhdc", service.totalHoaDonCho());
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
    model.addAttribute("listhdc", service.getHoaDonChos());
    model.addAttribute("totalhdc", service.totalHoaDonCho());
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
    model.addAttribute("listhdc", service.getHoaDonChos());
    model.addAttribute("totalhdc", service.totalHoaDonCho());
    return "manager/hoadon/createhoadon.html";
  }

  @GetMapping({ "index", "" })
  public String getHoaDonIndexpages(Model model) {
    this.pageno = 1;
    this.searchtxt = "";
    if (hoaDon != null) {
      List<HoaDonChiTiet> listhdcChiTiets = hdctservice.getHoaDonChiTiets(hoaDon);
      model.addAttribute("listhdcChiTiets", listhdcChiTiets);
      model.addAttribute("totalprice", hdctservice.getTotalPrice(hoaDon));
    } else {
      hoaDonRequest = new HoaDonRequest();
    }
    List<ChiTietSanPham> list = service.getPageNo(searchtxt, this.pageno, rowcount, sortBy, sortDir);
    pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
    totalpage = service.getPageNumber(searchtxt, rowcount);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("hoaDonRequest", hoaDonRequest);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("searchtxt", searchtxt);
    model.addAttribute("rowcount", rowcount);
    model.addAttribute("searchtxt", searchtxt);
    model.addAttribute("listhdc", service.getHoaDonChos());
    model.addAttribute("totalhdc", service.totalHoaDonCho());
    return "manager/hoadon/createhoadon.html";
  }

  // end panigation

  @PostMapping("updateQuantity")
  public String updateQuantity(@RequestParam("id") UUID id,
      @RequestParam("quantity") Integer quantity) {
    System.out.println(id);
    System.out.println(quantity);
    hdctservice.updateSanPhamInHoaDon(quantity, hoaDon.getId(), id);
    return "redirect:/manager/createhoadon";
  }

  // @PostMapping("/user/cart/updateQuantity")
  // public String updateQuantity(@RequestParam("id") UUID id,
  // @RequestParam("quantity") Integer quantity) {
  // gioHangChiTietService.updateQuality(gioHang, id, quantity);
  // return "redirect:/user/cart";
  // }

  @GetMapping("addproduct/{idsanpham}")
  public String addProduct(@PathVariable("idsanpham") UUID id, Model model, RedirectAttributes redirAttrs) {
    if (hoaDon == null) {
      redirAttrs.addFlashAttribute("message", "Chưa tạo hóa đơn ?????????????");
      return "redirect:/manager/createhoadon";
    } else if (hoaDon.getId() != null) {
      hdctservice.addSanPhamInHoaDon(hoaDon.getId(), id);
    }
    return "redirect:/manager/createhoadon";
  }

  @GetMapping("removeproduct/{idsanpham}")
  public String removeprodcut(@PathVariable("idsanpham") UUID id, Model model) {
    if (hoaDon != null) {
      hdctservice.deleteHoaDonChiTiet(hoaDon.getId(), id);
    }
    return "redirect:/manager/createhoadon";
  }

  @PostMapping("createorder")
  public String createOrder(Model model, @Valid @ModelAttribute("hoaDonRequest") HoaDonRequest request,
      BindingResult theBindingResult) {
    if (theBindingResult.hasErrors()) {
      this.pageno = 1;
      this.searchtxt = "";
      List<ChiTietSanPham> list = service.getPageNo(searchtxt, this.pageno, rowcount, sortBy, sortDir);
      pagenumbers = service.getPanigation(searchtxt, rowcount, pageno);
      totalpage = service.getPageNumber(searchtxt, rowcount);
      model.addAttribute("totalpage", totalpage);
      model.addAttribute("list", list);
      model.addAttribute("pagenumber", pagenumbers);
      model.addAttribute("crpage", pageno);
      model.addAttribute("searchtxt", searchtxt);
      model.addAttribute("rowcount", rowcount);
      model.addAttribute("searchtxt", searchtxt);
      model.addAttribute("listhdc", service.getHoaDonChos());
      model.addAttribute("totalhdc", service.totalHoaDonCho());
      return "manager/hoadon/createhoadon.html";
    }
    String idhoadon = service.createHoaDon(nhanVienRepo.findAll().get(0).getId(), request);
    hoaDon = hoaDonService.getHoaDonById(UUID.fromString(idhoadon));
    hoaDonRequest.setId(UUID.fromString(idhoadon));
    return "redirect:/manager/createhoadon";
  }

  @GetMapping(value = "thanhtoanthanhcong")
  public String getThanhToan(Model model, RedirectAttributes redirAttrs) {
    if (hoaDon == null) {
      redirAttrs.addFlashAttribute("message", "Chưa tạo hóa đơn ?????????????");
      return "redirect:/manager/createhoadon";
    } else if (hoaDon.getId() != null) {
      service.thanhToanHoaDon(hoaDon.getId());
      model.addAttribute("orderdetail", hoaDonService.getOrderDetail(hoaDon.getId()));
      hoaDon = new HoaDon();
      hoaDonRequest = new HoaDonRequest();
      return "user/orderdetail.html";
    }
    return "redirect:/manager/createhoadon";
  }

  @GetMapping("waitingorder/{id}")
  public String getHoaDonCho(Model model, @PathVariable("id") UUID idHoaDonCho) {
    System.out.println(idHoaDonCho);
    hoaDon = hoaDonService.getHoaDonById(idHoaDonCho);
    System.out.println(hoaDon.getMa());
    hoaDonRequest = new HoaDonRequest(hoaDon.getId(), hoaDon.getTenNguoiNhan(), hoaDon.getDiaChi(), hoaDon.getSdt());
    return "redirect:/manager/createhoadon";
  }

  @GetMapping("new")
  public String reset() {
    hoaDonRequest = new HoaDonRequest();
    hoaDon = new HoaDon();
    return "redirect:/manager/createhoadon";
  }

}
