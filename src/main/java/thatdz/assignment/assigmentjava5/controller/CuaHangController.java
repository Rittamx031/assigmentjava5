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
import thatdz.assignment.assigmentjava5.service.CuaHangService;

@Controller
@RequestMapping("manager/cuahang")
public class CuaHangController {
    @Autowired
    public CuaHangService service;
    @Autowired
    public CuaHang cuahang;

    @GetMapping("index")
    public String getCuaHangIndexpages(Model model) {
        List<CuaHang> list = service.getCuaHangs();
        model.addAttribute("list", list);
        return "manager/cuahang/index.html";
    }

    @ModelAttribute("cuahang")
    public CuaHang setSignUpForm() {
        return cuahang;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        cuahang = new CuaHang();
        return "manager/cuahang/form.html";
    }

    @GetMapping("delete")
    public String deleteCuaHang(Model model, @RequestParam("id") String id) {
        service.deleteCuaHang(UUID.fromString(id));
        List<CuaHang> listCuaHang = service.getCuaHangs();
        model.addAttribute("list", listCuaHang);
        return "manager/cuahang/index.html";
    }

    @GetMapping("edit")
    public String editCuaHang(Model model, @RequestParam("id") String id) {
        model.addAttribute("cuahang", service.getCuaHangById(UUID.fromString(id)));
        return "manager/cuahang/update.html";
    }

    @PostMapping("store")
    public String storeCuaHang(Model model, @Valid @ModelAttribute("cuahang") CuaHang cuahang,
            BindingResult theBindingResult) {
        System.out.println(cuahang);
        if (theBindingResult.hasErrors()) {
            return "manager/cuahang/form.html";
        } else {
            service.saveCuaHang(cuahang);
            model.addAttribute("list", service.getCuaHangs());
            cuahang = new CuaHang();
            return "manager/cuahang/index.html";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("cuahang") CuaHang cuahang, BindingResult theBindingResult,
            Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/cuahang/update.html";
        }
        service.updateCuaHang(cuahang);
        model.addAttribute("list", service.getCuaHangs());
        cuahang = new CuaHang();
        return "manager/cuahang/index.html";
    }
}
