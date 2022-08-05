package com.dbschool.Tema2Spring.repository;

import com.dbschool.Tema2Spring.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    public List<Orders> findAll();

}
