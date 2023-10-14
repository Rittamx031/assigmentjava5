package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.HoaDon;
import thatdz.assignment.assigmentjava5.service.HoaDonService;

@Controller
@RequestMapping("manager/hoadon")
public class HoaDonController {

  @Autowired
  private HoaDonService service;
  @Autowired
  private HoaDon voucherRequest;
  public int rowcount = 10;
  public int[] pagenumbers;
  public String sortBy = "ngayTao";
  public boolean sortDir = true;
  public int pageno = 0;
  public int totalpage = 0;

  @ModelAttribute("rowcount")
  public int rowcount() {
    return rowcount;
  }

  // panigation and sort
  @GetMapping("/getcountrow")
  public String getCountRow(Model model, @RequestParam("selectedValue") String selectedValue) {
    System.out.println(selectedValue);
    rowcount = Integer.parseInt(selectedValue);
    pagenumbers = service.getPanigation(rowcount, pageno);
    this.pageno = 1;
    List<HoaDon> list = service.getPageNo(1, rowcount, sortBy, sortDir);
    totalpage = service.getPageNumber(rowcount);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);
    return "manager/hoadon/hoadonpage.html"; // Redirect back to the form page
  }

  @GetMapping("sort")
  public String getPageSort(Model model, @RequestParam("sortBy") String sortby,
      @RequestParam("sortDir") boolean sordir) {
    this.sortBy = sortby;
    this.sortDir = sordir;
    this.pageno = 1;
    List<HoaDon> list = service.getPageNo(this.pageno, rowcount, this.sortBy, this.sortDir);
    totalpage = service.getPageNumber(rowcount);
    pagenumbers = service.getPanigation(rowcount, pageno);
    model.addAttribute("list", list);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);
    return "manager/hoadon/hoadonpage.html";
  }

  @GetMapping("/page")
  public String getPageNo(Model model, @RequestParam("pageno") int pageno) {
    if (pageno <= 1) {
      this.pageno = 1;
      pageno = 1;
    }
    this.pageno = pageno;
    System.out.println(pageno);
    List<HoaDon> list = service.getPageNo(this.pageno, rowcount, sortBy, sortDir);
    totalpage = service.getPageNumber(rowcount);
    model.addAttribute("totalpage", totalpage);
    pagenumbers = service.getPanigation(rowcount, this.pageno);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", this.pageno);
    model.addAttribute("list", list);
    model.addAttribute("rowcount", rowcount);
    return "manager/hoadon/hoadonpage.html";
  }

  // end
  @GetMapping({ "index", "" })
  public String getHoaDonIndexpages(Model model) {
    this.pageno = 1;
    List<HoaDon> list = service.getPageNo(this.pageno, rowcount, sortBy, sortDir);
    pagenumbers = service.getPanigation(rowcount, pageno);
    totalpage = service.getPageNumber(rowcount);
    model.addAttribute("totalpage", totalpage);
    model.addAttribute("list", list);
    model.addAttribute("pagenumber", pagenumbers);
    model.addAttribute("crpage", pageno);
    model.addAttribute("rowcount", rowcount);

    return "manager/hoadon/hoadonpage.html";
  }

  @ModelAttribute("voucherRequest")
  public HoaDon setSignUpForm() {
    return voucherRequest;
  }

  @GetMapping("create")
  public String goToCreateForm(Model model) {
    return "manager/hoadon/createhoadon.html";
  }

  @GetMapping("delete")
  public String deleteHoaDon(Model model, @RequestParam("id") String id, RedirectAttributes redirAttrs) {
    try {
      // service.deleteChucVu(UUID.fromString(id));
    } catch (Exception e) {
      redirAttrs.addFlashAttribute("message", "Không thể xóa thực thể này" + e);
    }
    // service.deleteHoaDon(UUID.fromString(id));
    return "redirect:index";
  }

  // @GetMapping("edit")
  // public String editHoaDon(Model model, @RequestParam("id") UUID id) {
  // model.addAttribute("voucherRequest",
  // service.getHoaDonRequetById(id));
  // return "/admin/pages/voucher/form-voucher.html";
  // }
  @GetMapping("edit")
  public String editHoaDon(Model model, @RequestParam("id") UUID id) {
    model.addAttribute("voucherRequest",
        service.getHoaDonById(id));
    return "/admin/pages/voucher/update-voucher.html";
  }

  @PostMapping("store")
  public String storeHoaDon(Model model, @Valid @ModelAttribute("voucherRequest") HoaDon voucherRequest,
      BindingResult theBindingResult) {
    if (theBindingResult.hasErrors()) {
      return "/admin/pages/voucher/form-voucher.html";
    } else {
      service.saveHoaDon(voucherRequest);
      return "redirect:index";
    }
  }

  @PostMapping("update")
  public String update(@Valid @ModelAttribute("voucherRequest") HoaDon voucherRequest,
      BindingResult theBindingResult, Model model) {
    if (theBindingResult.hasErrors()) {
      return "/admin/pages/voucher/update-voucher.html";
    }
    service.updateHoaDon(voucherRequest);
    return "redirect:index";
  }
}
