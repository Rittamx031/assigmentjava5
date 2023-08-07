package asm_banhang.demo.dao;

import asm_banhang.demo.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRes extends JpaRepository<Categories,Integer> {
}
