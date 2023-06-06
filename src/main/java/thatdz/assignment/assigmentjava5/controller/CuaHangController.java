package thatdz.assignment.assigmentjava5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
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
    public int rowcount = 10;
    public int[] pagenumbers;
    public String sortBy="ma", sortDir="asc";
    //panigation and sort
    @GetMapping("/getcountrow")
    public String handleSubmit(Model model,@RequestParam("selectedValue") String selectedValue, HttpServletRequest request) {
        System.out.println(selectedValue);
        if (selectedValue.equals("ALL")){
            rowcount = Integer.MAX_VALUE;
        }else{
            rowcount = Integer.parseInt(selectedValue);
        }
        pagenumbers= service.getPageNumber(rowcount);
        List<CuaHang> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/cuahang/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<CuaHang> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/cuahang/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<CuaHang> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/cuahang/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<CuaHang> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/cuahang/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<CuaHang> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/cuahang/index.html";
    }
    //crud 
    @GetMapping("index")
    public String getCuaHangIndexpages(Model model) {
        List<CuaHang> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
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
