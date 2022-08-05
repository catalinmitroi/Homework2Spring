package com.dbschool.Tema2Spring.controller;

import com.dbschool.Tema2Spring.dto.CustomersDTO;
import com.dbschool.Tema2Spring.mapper.CustomersMapper;
import com.dbschool.Tema2Spring.model.Customers;
import com.dbschool.Tema2Spring.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @GetMapping
    public List<CustomersDTO> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomersDTO getById(@PathVariable("id") Integer id) {
        return customersService.getById(id);
    }

    @RequestMapping("/getByName")
    public List<Customers> getByName(@RequestParam(value="name", required=true) String name) {
        return customersService.getByName("name");
    }

    @PostMapping
    public Customers save(@RequestBody Customers customers){
        return customersService.saveCustomer(customers);
    }

    @PutMapping("{id}")
    public Customers update(@RequestBody Customers customers, @PathVariable("id") Integer id){
        return customersService.updateCustomer(customers,id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id){
        customersService.deleteById(id);
        return "Deleted successfully";
    }

}
