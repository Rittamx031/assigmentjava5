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
@RequestMapping("chucvu")
public class ChucVuController {
    @Autowired
    private ChucVuService service;
    @Autowired
    private ChucVu chucvu;
    @GetMapping("index")
    public String getChucVuIndexpages(Model model) {
        List<ChucVu> list = service.getChucVus();
        model.addAttribute("list", list);
        return "manager/chucvu/index.html";
    }
    @ModelAttribute("ChucVu")
    public ChucVu setSignUpForm() {
        return chucvu;
    }
    @GetMapping("create")
        public String goToCreateForm(){
            chucvu = new ChucVu();
        return "manager/ChucVu/form.html";
    }
    @GetMapping("delete")
        public String deleteChucVu(Model model, @RequestParam("id") String id)
    {
        service.deleteChucVu(UUID.fromString(id));
        List<ChucVu> listchucvu = service.getChucVus();
        model.addAttribute("list",listchucvu);
        return "manager/ChucVu/index.html";
    }
    @GetMapping("edit")
    public String editChucVu(Model model,@RequestParam("id") String id){
        model.addAttribute("chucvu", service.getChucVuById(UUID.fromString(id)));
        return "manager/chucvu/update.html";
    }
    @PostMapping("store")
    public String storeChucVu(Model model,@Valid @ModelAttribute("chucvu") ChucVu chucvu, BindingResult theBindingResult){
        System.out.println(chucvu);
        if (theBindingResult.hasErrors()) {
            return "manager/chucvu/form.html";
        } else {
            service.saveChucVu(chucvu);
            model.addAttribute("list",service.getChucVus());
          return "manager/chucvu/index.html";
        }
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute("chucvu") ChucVu chucvu, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/chucvu/update.html";
        }
        service.updateChucvu(chucvu);
        model.addAttribute("list",service.getChucVus());
        return "manager/chucvu/index.html"; 
    }
}
