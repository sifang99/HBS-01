package com.sifang.controller;

import com.sifang.pojo.Doctor;
import com.sifang.pojo.ReturnMessage;
import com.sifang.service.DoctorService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ReturnMessage addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }

}
