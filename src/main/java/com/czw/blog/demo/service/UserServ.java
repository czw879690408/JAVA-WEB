package com.czw.blog.demo.service;

import com.czw.blog.demo.dao.UserMapper;
import com.czw.blog.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServ {
    @Autowired
    UserMapper userMapper;

    public User selectById(Integer id){
        return userMapper.selectById(id);
    }

    public User selectByAccount(String account){
        return userMapper.selectByAccount(account);
    }

    public int  insertUser(String userName,String userAccount,String userPassword){
       return userMapper.insert(userName,userAccount,userPassword);
    }
}
