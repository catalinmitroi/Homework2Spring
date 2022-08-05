package com.dbschool.Tema2Spring.repository;

import com.dbschool.Tema2Spring.dto.CustomersDTO;
import com.dbschool.Tema2Spring.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    public List<Customers> findAll();

    public List<Customers> getByName(String name);
}
