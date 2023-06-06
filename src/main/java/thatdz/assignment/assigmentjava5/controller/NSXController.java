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
import thatdz.assignment.assigmentjava5.entity.NSX;
import thatdz.assignment.assigmentjava5.service.NSXService;

@Controller
@RequestMapping("manager/nhasanxuat")
public class NSXController {
    @Autowired
    public NSXService service;
    @Autowired
    public NSX nsx;
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
        List<NSX> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/nsx/index.html"; // Redirect back to the form page
    }   
    @GetMapping("last")
    public String getLastPage(Model model) {
        List<NSX> list = service.getLastPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        return "manager/nsx/index.html";
    }
    @GetMapping("sort")
    public String getPageSort(Model model,@RequestParam("sortBy") String sortby,@RequestParam("sortDir") String sordir) {
        sortBy = sortby;
        sortDir= sordir;
        List<NSX> list = service.getFirstPage(rowcount,sortBy,sortDir);
        model.addAttribute("list", list);
        model.addAttribute("pagenumber", pagenumbers);
        return "manager/nsx/index.html";
    }
    @GetMapping("first")
    public String getFirstPages(Model model) {
        List<NSX> list = service.getFirstPage(rowcount,sortBy,sortDir);
        pagenumbers= service.getPageNumber(rowcount);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/nsx/index.html";
    }
    @GetMapping("/page")
    public String getPageNo(Model model,@RequestParam("pageno") int pageno) {
        List<NSX> list = service.getPageNo(pageno-1,rowcount,sortBy,sortDir);
        model.addAttribute("pagenumber", pagenumbers);
        model.addAttribute("list", list);
        return "manager/nsx/index.html";
    }
    @GetMapping("index")
    public String getNSXIndexpages(Model model) {
        List<NSX> list = service.getNSXs();
        model.addAttribute("list", list);
        return "manager/nsx/index.html";
    }
    @ModelAttribute("nsx")
    public NSX setSignUpForm() {
        return nsx;
    }
    @GetMapping("create")
        public String goToCreateForm(){
            nsx = new NSX();
        return "manager/nsx/form.html";
    }
    @GetMapping("delete")
        public String deleteNSX(Model model, @RequestParam("id") String id)
    {
        service.deleteNSX(UUID.fromString(id));
        List<NSX> listNSX = service.getNSXs();
        model.addAttribute("list",listNSX);
        return "manager/nsx/index.html";
    }
    @GetMapping("edit")
    public String editNSX(Model model,@RequestParam("id") String id){
        model.addAttribute("nsx", service.getNSXById(UUID.fromString(id)));
        return "manager/nsx/update.html";
    }
    @PostMapping("store")
    public String storeNSX(Model model,@Valid @ModelAttribute("nsx") NSX NSX, BindingResult theBindingResult){
        System.out.println(nsx);
        if (theBindingResult.hasErrors()) {
            return "manager/nsx/form.html";
        } else {
            service.saveNSX(nsx);
            model.addAttribute("list",service.getNSXs());
            nsx = new NSX();
          return "manager/nsx/index.html";
        }
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("nsx") NSX nsx, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/nsx/update.html";
        }
        service.updateNSX(nsx);
        model.addAttribute("list",service.getNSXs());
        nsx = new NSX();
        return "manager/nsx/index.html"; 
    }
}
