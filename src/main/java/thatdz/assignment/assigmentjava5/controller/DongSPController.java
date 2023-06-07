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

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.service.DongSPService;
import thatdz.assignment.assigmentjava5.uitls.ImageManager;

@Controller
@RequestMapping("manager/dongsp")
public class DongSPController {
    @Autowired
    private DongSPService service;
    @Autowired
    private DongSP dongsp;
    File file2 = new File("");
    public String pathCopyF = file2.getAbsolutePath()+"\\src\\main\\webapp\\assets\\img\\dongsp\\";
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
        List<DongSP> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/dongsanpham/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<DongSP> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/dongsanpham/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<DongSP> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/dongsanpham/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<DongSP> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/dongsanpham/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<DongSP> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/dongsanpham/index.html";
    }
    @GetMapping("index")
    public String getDongSPIndexpages(Model model) {
        List<DongSP> list = service.getDongSPs();
        model.addAttribute("list", list);
        return "manager/dongsanpham/index.html";
    }

    @ModelAttribute("dongsp")
    public DongSP setSignUpForm() {
        return dongsp;
    }

    @GetMapping("create")
    public String goToCreateForm() {
        dongsp = new DongSP();
        return "manager/dongsanpham/form.html";
    }

    @GetMapping("delete")
    public String deleteDongSP(Model model, @RequestParam("id") String id) {
        service.deleteDongSP(UUID.fromString(id));
        return "redirect:index";
    }

    @GetMapping("edit")
    public String editDongSP(Model model, @RequestParam("id") String id) {
        model.addAttribute("dongsp", service.getDongSPById(UUID.fromString(id)));
        return "manager/dongsanpham/update.html";
    }

    @PostMapping("store")
    public String storeDongSP(Model model, @Valid @ModelAttribute("dongsp") DongSP dongsp1,@RequestParam("imageFile") MultipartFile file,
            BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "manager/dongsanpham/form.html";
        } else {
            dongsp1.setImageName(UUID.randomUUID()+".png");
            ImageManager.copyFile(pathCopyF + dongsp1.getImageName(), file);
            service.saveDongSP(dongsp1);
            model.addAttribute("list", service.getDongSPs());
            dongsp = new DongSP();
            return "redirect:index";
        }
    }
    
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("dongsp") DongSP dongsp1, BindingResult theBindingResult, Model model,@RequestParam("imageFile") MultipartFile file) {
        if (theBindingResult.hasErrors()) {
            return "manager/dongsanpham/update.html";
        }
        if(dongsp1.getImageName()==null || dongsp1.getImageName()=="null"){
            dongsp1.setImageName(UUID.randomUUID()+".png");
        }
        System.out.println(dongsp1.getImageName());
        ImageManager.copyFile(pathCopyF + dongsp1.getImageName(), file);
        service.updateDongSP(dongsp1);
        model.addAttribute("list", service.getDongSPs());
        dongsp = new DongSP();
        return "redirect:index";
    }
}
