package thatdz.assignment.assigmentjava5.controller;

import java.io.File;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.dto.request.Login;
import thatdz.assignment.assigmentjava5.dto.request.SignUp;
import thatdz.assignment.assigmentjava5.entity.GioHang;
import thatdz.assignment.assigmentjava5.entity.GioHangChiTiet;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.service.GioHangChiTietService;
import thatdz.assignment.assigmentjava5.service.GioHangService;
import thatdz.assignment.assigmentjava5.service.KhachHangService;
import thatdz.assignment.assigmentjava5.uitls.ImageManager;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public KhachHangService service;
    @Autowired
    public SignUp signup;
    @Autowired
    public KhachHang khachHang;
    @Autowired
    public Login login;
    @Autowired
    public GioHang gioHang;
    @Autowired
    public GioHangChiTiet gioHangChiTiet;
    @Autowired
    public GioHangService gioHangService;
    @Autowired
    public GioHangChiTietService gioHangChiTietService;
    File file2 = new File("");
    public String pathCopyF = file2.getAbsolutePath()+"\\src\\main\\webapp\\assets\\img\\user\\";
    @ModelAttribute("signup")
    public SignUp signupatrr() {
        return signup;
    }

    @ModelAttribute("login")
    public Login loginatr() {
        return login;
    }

    @GetMapping("signup")
    public String getSignUpPage() {
        return "/user/signup.html";
    }

    @PostMapping("signup")
    public String Registration(@Valid @ModelAttribute("signup") SignUp signUp, BindingResult theBindingResult,
            Model model,@RequestParam("imageFile") MultipartFile file) {
        if (theBindingResult.hasErrors()) {
            return "user/signup.html";
        } else {
            if (signUp.getMatKhau().equals(signUp.getMatKhaurepeat())) {
                signUp.setImage(UUID.randomUUID() + ".png");
                ImageManager.copyFile(pathCopyF + signUp.getImage(), file);
                service.signUp(signUp);
            } else {
                model.addAttribute("signupstate", "password and password reapet not match!!!");
                return "user/signup.html";
            }
            return "redirect:/user/login";
        }
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "/user/login.html";
    }

    @PostMapping("login")
    public String Login(@Valid @ModelAttribute("login") Login login, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "user/login.html";
        } else {
            System.out.println(login.toString());
            khachHang = service.login(login);
            if (khachHang == null) {
                model.addAttribute("loginstate", "Login fail !!! user or password Incorrect!!!!");
            return "user/login.html";
            }
            return "redirect:/thatpee/index";
        }
    }
}
