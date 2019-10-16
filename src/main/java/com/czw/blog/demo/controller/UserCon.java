package com.czw.blog.demo.controller;

import com.czw.blog.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserCon {

    @Autowired
    UserServ userServ;

    @PostMapping("regist")
    public String regist(@RequestParam("username")String userName,
                         @RequestParam("userAccount")String userAccount,
                         @RequestParam("userPassword")String userPassword,
                         @RequestParam("userAge")Integer userAge,
                         @RequestParam("userSex")Integer userSex,
                         @RequestParam("type")Integer type){

        System.out.println("开始插入");
       if (userServ.insertUsers(userName,userAccount,userPassword,userAge,userSex,type)==1){
           System.out.println("用户" + userName + "添加成功！");
       }
        return "redirect:../";
    }
    public String addUser(@RequestParam("username")String userName,
                          @RequestParam("userAccount")String userAccount,
                          @RequestParam("userPassword")String userPassword,
                          @RequestParam("userAge")Integer userAge,
                          @RequestParam("userSex")Integer userSex,
                          @RequestParam("type")Integer type) {
        userServ.insertUsers(userName, userAccount, userPassword,userAge,userSex,type);
        return "redirect:memberlist";
    }
}
