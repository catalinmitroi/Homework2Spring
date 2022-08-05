package com.dbschool.Tema2Spring.mapper;

import com.dbschool.Tema2Spring.dto.OrdersDTO;
import com.dbschool.Tema2Spring.model.Orders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersDTO toOrdersDTO(Orders orders);
}
