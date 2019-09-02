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
    public String regist(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("useraccount") String account){

        System.out.println("开始插入");
       if (userServ.insertUser(username,account,password)==1){
           System.out.println("用户" + username + "添加成功！");
       }
        return "redirect:../";
    }
}
