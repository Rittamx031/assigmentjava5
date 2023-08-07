package asm_banhang.demo.service;


import asm_banhang.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();

    List<Product> findByCategories_Id(Integer cid);

    Product finById(Integer id);
}
