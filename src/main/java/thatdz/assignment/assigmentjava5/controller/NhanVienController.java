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

import thatdz.assignment.assigmentjava5.entity.CuaHang;
import thatdz.assignment.assigmentjava5.entity.NhanVien;
import thatdz.assignment.assigmentjava5.service.CuaHangService;
import thatdz.assignment.assigmentjava5.service.NhanVienService;

@Controller
@RequestMapping("nhanvien")
public class NhanVienController {
    @Autowired
    public NhanVienService service;
    @Autowired
    public CuaHangService chservice;

    @GetMapping("index")
    public String getnhanvienHomepage(Model model) {
        List<NhanVien> list = service.getNhanViens();
        model.addAttribute("list", list);
        return "nhanvien/index.jsp";
    }

    @Autowired
    public NhanVien nhanvien;

    @ModelAttribute("nhanvien")
    public NhanVien setSignUpForm() {
        nhanvien = new NhanVien();
        return nhanvien;
    }

    @ModelAttribute("listch")
    public List<CuaHang> setCboCuaHang() {
        return chservice.getCuaHangs();
    }

    @GetMapping("create")
    public String goToCreateForm() {
        nhanvien = new NhanVien();
        return "nhanvien/form.jsp";
    }

    @GetMapping("delete")
    public String deleteNhanVien(Model model, @RequestParam("id") String id) {
        service.deleteNhanVien(UUID.fromString(id));
        List<NhanVien> listNhanVien = service.getNhanViens();
        model.addAttribute("list", listNhanVien);
        return "nhanvien/index.jsp";
    }

    @GetMapping("edit")
    public String editNhanVien(Model model, @RequestParam("id") String id) {
        model.addAttribute("nhanvien", service.getNhanVienById(UUID.fromString(id)));
        return "nhanvien/update.jsp";
    }

    @PostMapping("store")
    public String storeNhanVien(Model model, @Valid @ModelAttribute("nhanvien") NhanVien nhanvien,
            BindingResult theBindingResult) {
        System.out.println(nhanvien.toString());
        if (theBindingResult.hasErrors()) {
            return "nhanvien/form.jsp";
        } else {
            service.saveNhanVien(nhanvien);
            model.addAttribute("list", service.getNhanViens());
            return "nhanvien/index.jsp";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult theBindingResult,
            Model model) {
        if (theBindingResult.hasErrors()) {
            return "nhanvien/update.jsp";
        }
        service.updateNhanVien(nhanvien);
        model.addAttribute("list", service.getNhanViens());
        return "nhanvien/index.jsp";
    }
}
