package com.dbschool.Tema2Spring.controller;

import com.dbschool.Tema2Spring.dto.ProductsDTO;
import com.dbschool.Tema2Spring.model.Orders;
import com.dbschool.Tema2Spring.model.Products;
import com.dbschool.Tema2Spring.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping
    public List<ProductsDTO> getAllProd(){
        return productsService.getAllProducts();
    }

    @GetMapping("{ID}")
    public ProductsDTO getById(@PathVariable("ID") Integer id){
        return productsService.getById(id);
    }

    @PostMapping
    public Products save(@RequestBody Products products){
        return productsService.saveProducts(products);
    }


    @PutMapping("{id}")
    public Products update(@RequestBody Products products, @PathVariable("id") Integer id){
        return productsService.updateProducts(products,id);
    }

    @DeleteMapping("{id}")
    public String DeleteById(@PathVariable("id") Integer id){
        productsService.deleteProducts(id);
        return "Deleted successfully";
    }
}
