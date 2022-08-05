package com.dbschool.Tema2Spring.mapper;

import com.dbschool.Tema2Spring.dto.ProductsDTO;
import com.dbschool.Tema2Spring.model.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductsMapper {

    ProductsDTO toProductsDTO(Products products);

}
