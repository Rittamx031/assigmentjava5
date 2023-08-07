package asm_banhang.demo.service;


import asm_banhang.demo.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Categories> findAll();
}
