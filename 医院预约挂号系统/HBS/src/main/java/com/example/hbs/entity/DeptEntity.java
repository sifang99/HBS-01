package com.example.hbs.entity;

import javax.persistence.*;

@Entity
//@Table(name = "dept")
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private Integer affiliate;//null-一级科室，int型数据-二级科室
    private String introduction;
}
