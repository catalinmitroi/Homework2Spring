package com.dbschool.Tema2Spring.service;

import com.dbschool.Tema2Spring.dto.OrdersDTO;
import com.dbschool.Tema2Spring.mapper.OrdersMapper;
import com.dbschool.Tema2Spring.model.Orders;
import com.dbschool.Tema2Spring.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersMapper ordersMapper;

    //GET ALL
    public List<OrdersDTO> getAllOrders(){
        return ordersRepository.findAll().stream()
                .map(ordersMapper::toOrdersDTO)
                .collect(Collectors.toList());
    }

    //GET BY ID
    public OrdersDTO getById(Integer id){
        return ordersMapper.toOrdersDTO(ordersRepository.findById(id).get());
    }

    //INSERT
    public Orders saveOrders(Orders orders){
        return ordersRepository.save(orders);
    }

    //UPDATE
    public Orders updateOrders(Orders orders, Integer id){
        Orders o = ordersRepository.findById(id).get();
        o.setStatus(orders.getStatus());
        o.setComments(orders.getComments());
        return ordersRepository.save(o);
    }

    //DELETE
    public void deleteOrders(Integer id){
        ordersRepository.deleteById(id);
    }
}
