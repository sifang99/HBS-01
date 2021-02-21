package com.sifang.service;

import com.sifang.pojo.UserLogin;

import java.util.List;

public interface UserService {
    //获得所有用户
    List<UserLogin> getUserList();
    //根据昵称查询用户
    UserLogin getUserByNickname(String nickname);
    //根据电话号码查询用户
    UserLogin getUserByTel(String tel);
    //用户登录
    int userLogin(String account, String pwd);
}
