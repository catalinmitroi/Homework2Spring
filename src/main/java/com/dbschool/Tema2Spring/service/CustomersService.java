package com.dbschool.Tema2Spring.service;

import com.dbschool.Tema2Spring.dto.CustomersDTO;
import com.dbschool.Tema2Spring.mapper.CustomersMapper;
import com.dbschool.Tema2Spring.model.Customers;
import com.dbschool.Tema2Spring.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    CustomersMapper customersMapper;

    public List<CustomersDTO> getAllCustomers() {
        return customersRepository.findAll().stream()
                .map(customersMapper::toCustomersDTO)
                .collect(Collectors.toList());
    }

    public CustomersDTO getById(Integer id){
        return customersMapper.toCustomersDTO(customersRepository.findById(id).get());
    }

    public List<Customers> getByName(String name) {
      return customersRepository.getByName(name);
    }

    public Customers saveCustomer(Customers customers){
        return customersRepository.save(customers);
    }

    public Customers updateCustomer(Customers customers, Integer id){

        Customers c = customersRepository.findById(id).get();
        c.setName(customers.getName());
        c.setEmail(customers.getEmail());
        return customersRepository.save(c);
    }

    public void deleteById(Integer id) {
        customersRepository.deleteById(id);
    }
}
