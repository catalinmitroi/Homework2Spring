package com.dbschool.Tema2Spring.repository;

import com.dbschool.Tema2Spring.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
