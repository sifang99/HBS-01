package com.sifang.controller;

import com.sifang.mapper.UserLoginMapper;
import com.sifang.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLoginController {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @RequestMapping("/getAllUsers")
    public List<UserLogin> getUserList(){
        List<UserLogin> userLoginList = userLoginMapper.getAllUser();
        return userLoginList;
    }
}
