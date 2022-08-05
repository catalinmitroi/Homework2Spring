package com.dbschool.Tema2Spring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Integer id;
    private String status;
    private String comments;
}
