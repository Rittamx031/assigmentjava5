package thatdz.assignment.assigmentjava5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import thatdz.assignment.assigmentjava5.entity.KhachHang;
import thatdz.assignment.assigmentjava5.entity.Login;
import thatdz.assignment.assigmentjava5.entity.SignUp;
import thatdz.assignment.assigmentjava5.service.KhachHangService;

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
    public String Registration(@Valid @ModelAttribute("signup") SignUp signUp, BindingResult theBindingResult, Model model) {
        if (theBindingResult.hasErrors()) {
            return "user/signup.html";
        } else {
            if(signUp.getMatKhau().equals(signUp.getMatKhaurepeat())){
                service.signUp(signUp);
            }else{
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
            KhachHang khachHang1 = service.login(login);
            if (khachHang1 == null) {
                model.addAttribute("loginstate", "Login fail !!! user or password Incorrect!!!!");
            return "user/login.html";
            }
            khachHang = khachHang1;
            return "redirect:/thatpee/index";
        }
    }
}
