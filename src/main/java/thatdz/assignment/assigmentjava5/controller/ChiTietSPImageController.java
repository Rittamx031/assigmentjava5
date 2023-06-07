package thatdz.assignment.assigmentjava5.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import thatdz.assignment.assigmentjava5.entity.ChiTietSanPham;
import thatdz.assignment.assigmentjava5.entity.image.SanPhamImage;
import thatdz.assignment.assigmentjava5.service.ChiTietSanPhamService;
import thatdz.assignment.assigmentjava5.service.SanPhamService;
import thatdz.assignment.assigmentjava5.service.image.SanPhamImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("imagesp")
public class ChiTietSPImageController {
    File file2 = new File("");
    public String pathCopyF = file2.getAbsolutePath()+"\\src\\main\\webapp\\assets\\img\\sanpham\\";
    @Autowired
    public SanPhamImageService service;
    @Autowired
    public ChiTietSanPhamService ctspservice;
    @Autowired
    public SanPhamService spservice;
    @Autowired
    public SanPhamImage sanPhamImage;
    @ModelAttribute("sanPhamImage")
    public SanPhamImage setForm() {
        sanPhamImage = new SanPhamImage();
        return sanPhamImage;
    }
    @GetMapping("addimage")
    public String getFormImage(Model model, @RequestParam("id") String id) {
        ChiTietSanPham ctsp = ctspservice.getChiTietSanPhamById(UUID.fromString(id));
        sanPhamImage.setChiTietSanPham(ctsp);
        model.addAttribute("ten", ctsp.getSanPham().getTen());
        model.addAttribute("sanPhamImage", sanPhamImage);
        return "/manager/chitietsanpham/imagemanager/selectimg.html";
    }
    
    @PostMapping("saveimage")
    public String saveImage() {
        //TODO: process POST request
        
        return "entity";
    }
}
