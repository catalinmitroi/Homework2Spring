package com.dbschool.Tema2Spring.mapper;

import com.dbschool.Tema2Spring.dto.CustomersDTO;
import com.dbschool.Tema2Spring.model.Customers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomersMapper {
    CustomersDTO toCustomersDTO(Customers customers);
}
