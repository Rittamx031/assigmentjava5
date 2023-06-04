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
import thatdz.assignment.assigmentjava5.entity.DongSP;
import thatdz.assignment.assigmentjava5.service.DongSPService;


@Controller
@RequestMapping("dongsp")
public class DongSPController {
    @Autowired 
    private DongSPService service;
    @Autowired
    private DongSP dongsp;
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
        public String goToCreateForm(){
            dongsp = new DongSP();
        return "manager/dongsanpham/form.html";
    }
    @GetMapping("delete")
        public String deleteDongSP(Model model, @RequestParam("id") String id)
    {
        service.deleteDongSP(UUID.fromString(id));
        List<DongSP> listDongSP = service.getDongSPs();
        model.addAttribute("list",listDongSP);
        return "manager/dongsanpham/index.html";
    }
    @GetMapping("edit")
    public String editDongSP(Model model,@RequestParam("id") String id){
        model.addAttribute("DongSP", service.getDongSPById(UUID.fromString(id)));
        return "manager/dongsanpham/update.html";
    }
    @PostMapping("store")
    public String storeDongSP(Model model,@Valid @ModelAttribute("dongsp") DongSP dongsp, BindingResult theBindingResult){
        System.out.println(dongsp);
        if (theBindingResult.hasErrors()) {
            return "manager/dongsanpham/form.html";
        } else {
            service.saveDongSP(dongsp);
            model.addAttribute("list",service.getDongSPs());
          return "manager/dongsanpham/index.html";
        }
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("dongsp") DongSP dongsp, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/dongsanpham/update.html";
        }
        service.updateDongSP(dongsp);
        model.addAttribute("list",service.getDongSPs());
        return "manager/dongsanpham/index.html"; 
    }
}
