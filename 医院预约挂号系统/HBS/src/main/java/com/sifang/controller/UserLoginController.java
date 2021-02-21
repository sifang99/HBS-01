package com.sifang.controller;

import com.sifang.mapper.UserLoginMapper;
import com.sifang.pojo.ReturnMessage;
import com.sifang.pojo.UserLogin;
import com.sifang.service.UserService;
import com.sifang.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserLoginController {

    @Autowired
    private UserService userService;
    private ReturnMessage returnMessage;//封装返回信息

    @RequestMapping("/getAllUsers")
    public List<UserLogin> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/userLogin")
    public ReturnMessage login(String account, String pwd){
        int result = userService.userLogin(account, pwd);
        returnMessage = new ReturnMessage();
        if(result == 0){
            returnMessage.setMessage("登录成功！");
        }else if(result == 1){
            returnMessage.setMessage("账号不存在！");
        }else if(result == 2){
            returnMessage.setMessage("密码错误！");
        }else{
            returnMessage.setMessage("登录失败！");
        }
        returnMessage.setIsSuccess(result);
        return returnMessage;
    }

    @RequestMapping("/userRegister")
    public ReturnMessage register(String nickname, String tel, String pwd){
        return userService.register(nickname, tel, pwd);
    };
}
