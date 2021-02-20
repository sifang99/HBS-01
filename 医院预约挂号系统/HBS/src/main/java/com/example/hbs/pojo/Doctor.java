package com.example.hbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private String number;
    private String name;
    private Integer gender;//0：女性，1：男性
    private String dept;
    private Date birth;
    private String position;
    private String speciality;
    private String introduction;
}
