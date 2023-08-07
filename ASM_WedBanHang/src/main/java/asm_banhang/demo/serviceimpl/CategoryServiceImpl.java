package asm_banhang.demo.serviceimpl;

import asm_banhang.demo.dao.CategoryRes;
import asm_banhang.demo.entity.Categories;
import asm_banhang.demo.service.CategoryService;
import asm_banhang.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRes categoryRes;

    @Override
    public List<Categories> findAll() {
        return categoryRes.findAll() ;
    }
}
