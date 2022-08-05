package com.dbschool.Tema2Spring.controller;

import com.dbschool.Tema2Spring.service.CustomersService;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomersViewController {

    @Autowired
    CustomersService customersService;

    @GetMapping("/customers")
    public String getCustomers(Model model){
        model.addAttribute("customers", customersService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String getById(Model model, @PathVariable("id") Integer id){
        model.addAttribute("customers", customersService.getById(id));
        return "customers";
    }

    @GetMapping("/customers/getByName/{name}")
    public String getByName(Model model, @RequestParam("name") String name){
        model.addAttribute("customers", customersService.getByName(name));
        return "customers";
    }
}
