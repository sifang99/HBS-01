package com.example.hbs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private String name;
    private Integer affiliate;//null-一级科室，int型数据-二级科室
    private String introduction;
}
