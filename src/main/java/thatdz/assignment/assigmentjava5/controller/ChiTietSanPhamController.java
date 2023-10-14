package thatdz.assignment.assigmentjava5.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.entity.MauSac;
import thatdz.assignment.assigmentjava5.entity.NSX;
import thatdz.assignment.assigmentjava5.entity.SanPham;
import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;
import thatdz.assignment.assigmentjava5.service.DongSPService;
import thatdz.assignment.assigmentjava5.service.MauSacService;
import thatdz.assignment.assigmentjava5.service.NSXService;
import thatdz.assignment.assigmentjava5.service.SanPhamService;
import thatdz.assignment.assigmentjava5.uitls.ImageManager;

@Controller
@RequestMapping("manager/chitietsanpham")
public class ChiTietSanPhamController {
    @Autowired
    public ChiTietSanPhamService service;
    @Autowired
    public SanPhamService spservice;
    @Autowired
    public NSXService nsxservice;
    @Autowired
    public MauSacService msservice;
    @Autowired
    public DongSPService dspservice;
    @Autowired
    private ChiTietSanPham chitietsanpham;
    File file2 = new File("");
    public String pathCopyF = file2.getAbsolutePath() + "\\src\\main\\webapp\\assets\\img\\sanpham\\";
    // sort and panigation
    public int rowcount = 10;
    public int[] pagenumbers;
    public String sortBy = "sanPham", sortDir = "asc";

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
        List<ChiTietSanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/chitietsanpham/index.html"; // Redirect back to the form page
    }

    @GetMapping("last")
    public String getLastPage(Model model) {
        List<ChiTietSanPham> list = service.getLastPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        return "manager/chitietsanpham/index.html";
    }

    @GetMapping("sort")
    public String getPageSort(Model model, @RequestParam("sortBy") String sortby,
            @RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir = sordir;
        List<ChiTietSanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/chitietsanpham/index.html";
    }

    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<ChiTietSanPham> list = service.getFirstPage(rowcount, sortBy, sortDir);
        pagenumbers = service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/chitietsanpham/index.html";
    }

    @GetMapping("page")
    public String getPageNo(Model model, @RequestParam("pageno") int pageno) {
        List<ChiTietSanPham> list = service.getPageNo(pageno - 1, rowcount, sortBy, sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/chitietsanpham/index.html";
    }

    @ModelAttribute("sanPhams")
    public List<SanPham> setCboSanPham() {
        return spservice.getSanPhams();
    }

    @ModelAttribute("nsxs")
    public List<NSX> setCboNSX() {
        return nsxservice.getNSXs();
    }

    @ModelAttribute("mauSacs")
    public List<MauSac> setCboMauSac() {
        return msservice.getMauSacs();
    }

    @ModelAttribute("dongSPs")
    public List<DongSP> setCboDongSP() {
        return dspservice.getDongSPs();
    }

    @GetMapping({ "index", "" })
    public String getChiTietSanPhamIndexpages(Model model) {
        List<ChiTietSanPham> list = service.getChiTietSanPhams();
        model.addAttribute("list", list);
        return "manager/chitietsanpham/index.html";
    }

    @ModelAttribute("chitietsanpham")
    public ChiTietSanPham setSignUpForm() {
        return chitietsanpham;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        chitietsanpham = new ChiTietSanPham();
        return "manager/chitietsanpham/form.html";
    }

    @GetMapping("delete")
    public String deleteChiTietSanPham(Model model, @RequestParam("id") String id, RedirectAttributes redirAttrs) {
        try {
            service.deleteChiTietSanPham(UUID.fromString(id));
        } catch (Exception e) {
            redirAttrs.addFlashAttribute("message", "Không thể xóa thực thể này" + e);
        }
        return "redirect:index";
    }

    @GetMapping("edit")
    public String editChiTietSanPham(Model model, @RequestParam("id") String id) {
        System.out.println(id);
        model.addAttribute("chitietsanpham", service.getChiTietSanPhamById(UUID.fromString(id)));

        return "manager/chitietsanpham/update.html";
    }

    @PostMapping("store")
    public String storeChiTietSanPham(Model model,
            @Valid @ModelAttribute("chitietsanpham") ChiTietSanPham chitietsanphamst,
            @RequestParam("imageFile") MultipartFile file,
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "manager/chitietsanpham/form.html";
        } else {
            chitietsanphamst.setImage(UUID.randomUUID() + ".png");
            ImageManager.copyFile(pathCopyF + chitietsanphamst.getImage(), file);
            service.saveChiTietSanPham(chitietsanphamst);
            model.addAttribute("list", service.getChiTietSanPhams());
            chitietsanpham = new ChiTietSanPham();
            return "redirect:index";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("chitietsanpham") ChiTietSanPham chitietsanphamud,
            @RequestParam("imageFile") MultipartFile file,
            BindingResult theBindingResult, Model model) {
        System.out.println(chitietsanphamud.toString());
        if (theBindingResult.hasErrors()) {
            return "manager/chitietsanpham/update.html";
        }
        chitietsanphamud.setImage(UUID.randomUUID() + ".png");
        System.out.println();
        ImageManager.copyFile(pathCopyF + chitietsanphamud.getImage(), file);
        service.updateChiTietSanPham(chitietsanphamud);
        System.out.println(chitietsanphamud.toString());
        model.addAttribute("list", service.getChiTietSanPhams());
        return "redirect:index";
    }
}
