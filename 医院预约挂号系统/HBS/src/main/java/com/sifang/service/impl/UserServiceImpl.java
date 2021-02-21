package com.sifang.service.impl;


import com.sifang.mapper.UserLoginMapper;
import com.sifang.pojo.ReturnMessage;
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

    @Override
    public boolean checkNickname(String nickname) {
        int length = nickname.length();
        if(length == 0 || length > 20) return false;
        for (int i = 0; i < length; i++){
            char ch = nickname.charAt(i);
            if ((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 90) ||  (ch >= 97 && ch <= 122)|| ('\u4e00' <= ch  && ch <= '\u9fff')){
                if (i==0 && ch >= 48 && ch <= 57){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkTel(String tel) {
        int length = tel.length();
        if (length != 11) return false;
        for (int i=0; i < length; i++){
            if (tel.charAt(i) < 48 || tel.charAt(i) > 57) return false;
        }
        return true;
    }

    @Override
    public boolean checkPwd(String pwd) {
        int length = pwd.length();
        boolean includeNumber = false;
        boolean includeLetter = false;
        if (length < 12 || length > 20) return false;
        for (int i=0; i < length; i++){
            char ch = pwd.charAt(i);
            if (ch >= 48 && ch <= 57){
                includeNumber = true;
            }else if((ch >= 65 && ch <= 90) ||  (ch >= 97 && ch <= 122)){
                includeLetter = true;
            }else {
                return false;
            }
        }
        if (includeLetter && includeNumber){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isNicknameExist(String nickname) {
        UserLogin userLogin = userLoginMapper.getUserByNickname(nickname);
        if (userLogin != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isTelExist(String tel) {
        UserLogin userLogin = userLoginMapper.getUserByTel(tel);
        if (userLogin != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ReturnMessage register(String nickname, String tel, String pwd) {
        ReturnMessage returnMessage = new ReturnMessage();
        if (this.checkNickname(nickname)){
            if (this.isNicknameExist(nickname)){
                returnMessage.setIsSuccess(1);
                returnMessage.setMessage("昵称已经存在！");
                return returnMessage;
            }
            if(this.checkTel(tel)){
                if (this.isTelExist(tel)){
                    returnMessage.setIsSuccess(2);
                    returnMessage.setMessage("该电话号码已注册！");
                    return returnMessage;
                }
                if (this.checkPwd(pwd)){
                    if (userLoginMapper.addUser(tel, nickname, pwd)){
                        returnMessage.setIsSuccess(0);
                        returnMessage.setMessage("注册成功！");
                        return returnMessage;
                    }else{
                        returnMessage.setIsSuccess(3);
                        returnMessage.setMessage("注册失败！无法插入数据");
                        return returnMessage;
                    }

                }else {
                    returnMessage.setIsSuccess(3);
                    returnMessage.setMessage("密码不符合规范！");
                    return returnMessage;
                }
            }else{
                returnMessage.setIsSuccess(3);
                returnMessage.setMessage("请填入正确的电话号码！");
                return returnMessage;
            }
        }else{
            returnMessage.setIsSuccess(3);
            returnMessage.setMessage("昵称不符合规范！");
            return returnMessage;
        }
    }
}
