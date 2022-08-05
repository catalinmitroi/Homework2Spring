package com.dbschool.Tema2Spring.controller;

import com.dbschool.Tema2Spring.dto.OrdersDTO;
import com.dbschool.Tema2Spring.model.Orders;
import com.dbschool.Tema2Spring.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<OrdersDTO> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @GetMapping("{id}")
    public OrdersDTO getById(@PathVariable("id") Integer id){
        return ordersService.getById(id);
    }

    @PostMapping
    public Orders save(@RequestBody Orders orders){
        return ordersService.saveOrders(orders);
    }

    @PutMapping("{id}")
    public Orders update(@RequestBody Orders orders, @PathVariable("id") Integer id){
        return ordersService.updateOrders(orders,id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id){
        ordersService.deleteOrders(id);
        return "Deleted Successfully";
    }
}
