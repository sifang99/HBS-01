package com.sifang.mapper;

import com.sifang.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    List<UserLogin> getAllUser();
    UserLogin getUserByNickname(String nickname);
    UserLogin getUserByTel(String tel);
    boolean addUser(String tel, String nickname, String pwd);
}