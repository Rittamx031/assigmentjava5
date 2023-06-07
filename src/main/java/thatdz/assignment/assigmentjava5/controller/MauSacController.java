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

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.MauSac;
import thatdz.assignment.assigmentjava5.service.MauSacService;

@Controller
@RequestMapping("manager/mausac")
public class MauSacController {
    @Autowired
    private MauSacService service;
    @Autowired
    private MauSac mausac;
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
        List<MauSac> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/mausac/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<MauSac> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/mausac/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<MauSac> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/mausac/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<MauSac> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/mausac/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<MauSac> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/mausac/index.html";
    }
    @GetMapping("index")
    public String getMauSacIndexpages(Model model) {
        List<MauSac> list = service.getMauSacs();
        model.addAttribute("list", list);
        return "manager/mausac/index.html";
    }

    @ModelAttribute("mausac")
    public MauSac setSignUpForm() {
        return mausac;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        mausac = new MauSac();
        return "manager/mausac/form.html";
    }

    @GetMapping("delete")
    public String deleteMauSac(Model model, @RequestParam("id") String id) {
        service.deleteMauSac(UUID.fromString(id));
        return "redirect:index";
    }

    @GetMapping("edit")
    public String editMauSac(Model model, @RequestParam("id") String id) {
        model.addAttribute("mausac", service.getMauSacById(UUID.fromString(id)));
        return "manager/mausac/update.html";
    }

    @PostMapping("store")
    public String storeMauSac(Model model, @Valid @ModelAttribute("mausac") MauSac mausacst,
            BindingResult theBindingResult) {
        System.out.println(mausacst);
        if (theBindingResult.hasErrors()) {
            return "manager/mausac/form.html";
        } else {
            service.saveMauSac(mausacst);
            model.addAttribute("list", service.getMauSacs());
            return "redirect:index";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("mausac") MauSac mausacud, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "manager/mausac/update.html";
        }
        service.updateMauSac(mausacud);
        return "redirect:index";
    }
}
