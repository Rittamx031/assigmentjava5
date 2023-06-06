package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import thatdz.assignment.assigmentjava5.entity.ChucVu;
import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.entity.NhanVien;
import thatdz.assignment.assigmentjava5.service.ChucVuService;
import thatdz.assignment.assigmentjava5.service.CuaHangService;
import thatdz.assignment.assigmentjava5.service.NhanVienService;

@Controller
@RequestMapping("manager/nhanvien")
public class NhanVienController {
    @Autowired
    public NhanVienService service;
    @Autowired
    public CuaHangService chservice;
    @Autowired
    public ChucVuService cvservice;
    @GetMapping("index")
    public String getnhanvienHomepage(Model model) {
        List<NhanVien> list = service.getNhanViens();
        model.addAttribute("list", list);
        return "manager/nhanvien/index.html";
    }
    public int rowcount = 10;
    public int[] pagenumbers;
    public String sortBy="ma", sortDir="asc";
    //panigation and sort
    @GetMapping("/getcountrow")
    public String handleSubmit(Model model,@RequestParam("selectedValue") String selectedValue) {
        System.out.println(selectedValue);
        if (selectedValue.equals("ALL")){
            rowcount = Integer.MAX_VALUE;
        }else{
            rowcount = Integer.parseInt(selectedValue);
        }
        pagenumbers= service.getPageNumber(rowcount);
        List<NhanVien> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/nhanvien/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<NhanVien> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/nhanvien/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<NhanVien> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/nhanvien/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<NhanVien> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/nhanvien/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<NhanVien> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/nhanvien/index.html";
    }
    @Autowired
    public NhanVien nhanvien;

    @ModelAttribute("nhanvien")
    public NhanVien setSignUpForm() {
        nhanvien = new NhanVien();
        return nhanvien;
    }

    @ModelAttribute("listcv")
    public List<ChucVu> setCboChucVus() {
        return cvservice.getChucVus();
    }
    @ModelAttribute("listnv")
    public List<NhanVien> setCboNhanViens() {
        return service.getNhanViens();
    }
    @ModelAttribute("listch")
    public List<CuaHang> setCboCuaHang() {
        return chservice.getCuaHangs();
    }

    @GetMapping("create")
    public String goToCreateForm() {
        nhanvien = new NhanVien();
        return "manager/nhanvien/form.html";
    }

    @GetMapping("delete")
    public String deleteNhanVien(Model model, @RequestParam("id") String id) {
        service.deleteNhanVien(UUID.fromString(id));
        List<NhanVien> listNhanVien = service.getNhanViens();
        model.addAttribute("list", listNhanVien);
        return "manager/nhanvien/index.html";
    }

    @GetMapping("edit")
    public String editNhanVien(Model model, @RequestParam("id") String id) {
        model.addAttribute("nhanvien", service.getNhanVienById(UUID.fromString(id)));
        return "manager/nhanvien/update.html";
    }

    @PostMapping("store")
    public String storeNhanVien(Model model, @Valid @ModelAttribute("nhanvien") NhanVien nhanvien,
            BindingResult theBindingResult) {
        System.out.println(nhanvien.toString());
        if (theBindingResult.hasErrors()) {
            return "manager/nhanvien/form.html";
        } else {
            service.saveNhanVien(nhanvien);
            model.addAttribute("list", service.getNhanViens());
            nhanvien = new NhanVien();
            return "manager/nhanvien/index.html";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult theBindingResult,
            Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/nhanvien/update.html";
        }
        service.updateNhanVien(nhanvien);
        model.addAttribute("list", service.getNhanViens());
        nhanvien = new NhanVien();
        return "manager/nhanvien/index.html";
    }
}
