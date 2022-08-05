package com.dbschool.Tema2Spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Customers {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String email;

}
