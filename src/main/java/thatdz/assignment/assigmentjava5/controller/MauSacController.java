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
        List<MauSac> listMauSac = service.getMauSacs();
        model.addAttribute("list", listMauSac);
        return "manager/mausac/index.html";
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
            return "manager/mausac/index.html";
        }
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("mausac") MauSac mausacud, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "manager/mausac/update.html";
        }
        service.updateMauSac(mausacud);
        model.addAttribute("list", service.getMauSacs());
        return "manager/mausac/index.html";
    }
}
