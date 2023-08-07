package asm_banhang.demo.serviceimpl;


import asm_banhang.demo.dao.CategoryRes;
import asm_banhang.demo.dao.ProductRes;
import asm_banhang.demo.entity.Product;
import asm_banhang.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRes productRes;

    @Autowired
    CategoryRes categoryRes;

    @Override
    public List<Product> findAll() {
        return productRes.findAll();
    }

    @Override
    public List<Product> findByCategories_Id(Integer cid) {
        return productRes.findByCategories_Id(cid);
    }

    @Override
    public Product finById(Integer id) {
        return productRes.findById(id).get();
    }


}
