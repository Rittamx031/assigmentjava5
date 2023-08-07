package asm_banhang.demo.dao;

import asm_banhang.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRes extends JpaRepository<Product,Integer> {

    public List<Product> findByCategories_Id(Integer id);
}
