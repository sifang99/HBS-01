package com.example.hbs.controller;

import com.example.hbs.dao.doctorDAO;
import com.example.hbs.pojo.Doctor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class doctorController {

    //获取所有医生信息
    @RequestMapping("/getDoctors")
    public Collection<Doctor> getAllDoctors(){
        doctorDAO doctordao = new doctorDAO();
        return doctordao.getDoctor();
    }
}
