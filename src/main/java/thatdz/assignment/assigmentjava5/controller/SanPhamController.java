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
import thatdz.assignment.assigmentjava5.entity.SanPham;
import thatdz.assignment.assigmentjava5.service.SanPhamService;

/**
 * SanPhamController
 */
@Controller
@RequestMapping("manager/sanpham")
public class SanPhamController {
    @Autowired
    public SanPhamService service;
    @Autowired
    private SanPham sanpham;
    public int rowcount = 10;
    public int[] pagenumbers;
    public String sortBy = "ma", sortDir = "asc";

    // panigation and sort
    @GetMapping("/getcountrow")
    public String handleSubmit(Model model, @RequestParam("selectedValue") String selectedValue) {
        System.out.println(selectedValue);
        if (selectedValue.equals("ALL")) {
            rowcount = Integer.MAX_VALUE;
        } else {
            rowcount = Integer.parseInt(selectedValue);
        }
        pagenumbers = service.getPageNumber(rowcount);
        List<SanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/sanpham/index.html"; // Redirect back to the form page
    }

    @GetMapping("last")
    public String getLastPage(Model model) {
        List<SanPham> list = service.getLastPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        return "manager/sanpham/index.html";
    }

    @GetMapping("sort")
    public String getPageSort(Model model, @RequestParam("sortBy") String sortby,
            @RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir = sordir;
        List<SanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/sanpham/index.html";
    }

    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<SanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        pagenumbers = service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/sanpham/index.html";
    }

    @GetMapping("/page")
    public String getPageNo(Model model, @RequestParam("pageno") int pageno) {
        List<SanPham> list = service.getPageNo(pageno - 1, rowcount, sortBy, sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/sanpham/index.html";
    }

    @GetMapping("index")
    public String getSanPhamIndexpages(Model model) {
        List<SanPham> list = service.getSanPhams();
        model.addAttribute("list", list);
        return "manager/sanpham/index.html";
    }

    @ModelAttribute("sanpham")
    public SanPham setSignUpForm() {
        return sanpham;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        sanpham = new SanPham();
        return "manager/sanpham/form.html";
    }

    @GetMapping("delete")
    public String deleteSanPham(Model model, @RequestParam("id") String id, RedirectAttributes redirAttrs) {
        try {
            service.deleteSanPham(UUID.fromString(id));
        } catch (Exception e) {
            redirAttrs.addFlashAttribute("message", "Không thể xóa thực thể này" + e);
        }
        List<SanPham> listSanPham = service.getSanPhams();
        model.addAttribute("list", listSanPham);
        return "manager/sanpham/index.html";

    }

    @GetMapping("edit")
    public String editSanPham(Model model, @RequestParam("id") String id) {
        model.addAttribute("sanpham", service.getSanPhamById(UUID.fromString(id)));
        return "manager/sanpham/update.html";
    }

    @PostMapping("store")
    public String storeSanPham(Model model, @Valid @ModelAttribute("sanpham") SanPham sanpham,
            BindingResult theBindingResult) {
        System.out.println(sanpham);
        if (theBindingResult.hasErrors()) {
            return "manager/sanpham/form.html";
        } else {
            service.saveSanPham(sanpham);
            model.addAttribute("list", service.getSanPhams());
            sanpham = new SanPham();
            return "manager/sanpham/index.html";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("sanpham") SanPham sanpham, BindingResult theBindingResult,
            Model model) {
        System.out.println(sanpham);
        if (theBindingResult.hasErrors()) {
            return "manager/sanpham/update.html";
        }
        service.updateSanPham(sanpham);
        model.addAttribute("list", service.getSanPhams());
        sanpham = new SanPham();
        return "manager/sanpham/index.html";
    }
}