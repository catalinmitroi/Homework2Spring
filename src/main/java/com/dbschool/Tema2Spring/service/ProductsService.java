package com.dbschool.Tema2Spring.service;

import com.dbschool.Tema2Spring.dto.ProductsDTO;
import com.dbschool.Tema2Spring.mapper.ProductsMapper;
import com.dbschool.Tema2Spring.model.Products;
import com.dbschool.Tema2Spring.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService{

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    ProductsMapper productsMapper;
    //GET ALL

    public List<ProductsDTO> getAllProducts(){
        return productsRepository.findAll().stream()
                .map(productsMapper::toProductsDTO)
                .collect(Collectors.toList());
    }

    //GET BY ID
    public ProductsDTO getById(Integer id){
        return productsMapper.toProductsDTO(productsRepository.findById(id).get());
    }

    //INSERT
    public Products saveProducts(Products product){
        return productsRepository.save(product);
    }

    //UPDATE
    public Products updateProducts(Products products, Integer id){
        Products p = productsRepository.findById(id).get();
        p.setName(products.getName());
        p.setPrice(products.getPrice());
        return productsRepository.save(p);
    }

    //DELETE
    public void deleteProducts(Integer id){
        productsRepository.deleteById(id);
    }

}
