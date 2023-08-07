package asm_banhang.demo.controller;

import asm_banhang.demo.entity.Categories;
import asm_banhang.demo.entity.Product;
import asm_banhang.demo.service.CategoryService;
import asm_banhang.demo.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
   private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private HttpSession session;



    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, @RequestParam("cid") Optional<Integer>  cid) {

        if (cid.isEmpty()==false){
            System.out.println(cid.get());
            System.out.println(productService.findByCategories_Id(cid.get()));
            model.addAttribute("items", productService.findByCategories_Id(cid.get()));
            return "/product/list";
        }
        model.addAttribute("items", productService.findAll());
        return "/product/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Product p) {
        model.addAttribute("item",p);
        return "product/detail";
    }
}
