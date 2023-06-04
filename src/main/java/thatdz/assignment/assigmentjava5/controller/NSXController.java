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
@RequestMapping("nhasanxuat")
public class NSXController {
    @Autowired
    public NSXService service;
    @Autowired
    public NSX nsx;
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
