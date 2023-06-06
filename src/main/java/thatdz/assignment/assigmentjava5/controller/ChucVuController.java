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
import thatdz.assignment.assigmentjava5.entity.ChucVu;
import thatdz.assignment.assigmentjava5.service.ChucVuService;

@Controller
@RequestMapping("manager/chucvu")
public class ChucVuController {
    @Autowired
    private ChucVuService service;
    @Autowired
    private ChucVu chucvu;
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
        List<ChucVu> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/chucvu/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<ChucVu> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/chucvu/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<ChucVu> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/chucvu/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<ChucVu> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/chucvu/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<ChucVu> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/chucvu/index.html";
    }
    @GetMapping("index")
    public String getChucVuIndexpages(Model model) {
        List<ChucVu> list = service.getChucVus();
        model.addAttribute("list", list);
        return "manager/chucvu/index.html";
    }

    @ModelAttribute("chucvu")
    public ChucVu setSignUpForm() {
        return chucvu;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        chucvu = new ChucVu();
        return "manager/chucvu/form.html";
    }

    @GetMapping("delete")
    public String deleteChucVu(Model model, @RequestParam("id") String id) {
        service.deleteChucVu(UUID.fromString(id));
        List<ChucVu> listchucvu = service.getChucVus();
        model.addAttribute("list", listchucvu);
        return "manager/chucvu/index.html";
    }

    @GetMapping("edit")
    public String editChucVu(Model model, @RequestParam("id") String id) {
        model.addAttribute("chucvu", service.getChucVuById(UUID.fromString(id)));
        return "manager/chucvu/update.html";
    }

    @PostMapping("store")
    public String storeChucVu(Model model, @Valid @ModelAttribute("chucvu") ChucVu chucvust,
            BindingResult theBindingResult) {
        System.out.println(chucvust);
        if (theBindingResult.hasErrors()) {
            return "manager/chucvu/form.html";
        } else {
            service.saveChucVu(chucvust);
            model.addAttribute("list", service.getChucVus());
            return "manager/chucvu/index.html";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("chucvu") ChucVu chucvuud, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/chucvu/update.html";
        }
        service.updateChucvu(chucvuud);
        model.addAttribute("list", service.getChucVus());
        return "manager/chucvu/index.html";
    }
}
