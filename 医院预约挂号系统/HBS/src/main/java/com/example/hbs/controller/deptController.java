package com.example.hbs.controller;

import com.example.hbs.dao.deptDAO;
import com.example.hbs.pojo.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class deptController {

    //获得所有科室信息
    @RequestMapping("/getDepts")
    public Collection<Dept> getAllDepts(){
        deptDAO deptdao = new deptDAO();
        return deptdao.getDept();
    }
}
