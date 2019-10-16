package com.czw.blog.demo.controller;


import com.czw.blog.demo.dao.UserMapper;
import com.czw.blog.demo.model.User;
import com.czw.blog.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class LoginCon {

    @Autowired
    UserServ userServ;

    //登陆
    @GetMapping("")
    public String index(HttpServletRequest request, Map<String, Object> map) {
        return "index";
    }

    @PostMapping("login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password, HttpSession session, Map<String, Object> map) {
        User user = userServ.selectByAccount(account);
        if (user != null && user.getUserPassword().equals(password)) {
            session.setAttribute("user", user);
            if(user.getType() == 1)
//            map.put("user", user);
                return "redirect:home";
            else return "redirect:admin";
        } else return "index";
    }
}
