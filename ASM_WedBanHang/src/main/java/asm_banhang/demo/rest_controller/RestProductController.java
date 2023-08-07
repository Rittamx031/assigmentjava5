package asm_banhang.demo.rest_controller;


import asm_banhang.demo.entity.Product;
import asm_banhang.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest")
@CrossOrigin("*")
@RestController

public class RestProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getOne(@PathVariable("id") Integer id){
        return productService.finById(id);
    }
}
