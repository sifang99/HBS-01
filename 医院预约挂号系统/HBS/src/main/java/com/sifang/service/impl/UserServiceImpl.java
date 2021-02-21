package com.sifang.service.impl;


import com.sifang.mapper.UserLoginMapper;
import com.sifang.pojo.UserLogin;
import com.sifang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public List<UserLogin> getUserList() {
        return userLoginMapper.getAllUser();
    }

    //根据昵称查询用户
    @Override
    public UserLogin getUserByNickname(String nickname) {
        return userLoginMapper.getUserByNickname(nickname);
    }
    //根据电话号码查询用户
    @Override
    public UserLogin getUserByTel(String tel) {
        return userLoginMapper.getUserByTel(tel);
    }

    @Override
    public int userLogin(String account, String pwd) {
        char c = account.charAt(0);
        UserLogin userLogin;
        //判断用户是通过昵称进行登录，还是通过电话号码进行登录
        if ((c >= 65 && c <= 90) ||  (c >= 97 && c <= 122)|| ('\u4e00' <= c  && c <= '\u9fff')){
            userLogin = this.getUserByNickname(account);
        }else if(c >= 48 && c <= 57){
            userLogin = this.getUserByTel(account);
        }else{
            return 1;//账号不存在
        }
        if (userLogin.getPwd().equals(pwd)){
            return 0;//登录成功
        }else {
            return 2;//账号正确，密码错误
        }
    }
}
