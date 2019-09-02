package com.czw.music.controller;


import com.czw.music.dao.UserMapper;
import com.czw.music.enrity.musicuser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


@Controller
public class LoginCon {

    @Autowired
    UserMapper userMapper;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @PostMapping("login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password, Map<String,Object> map, HttpServletRequest request){


//        if(account.equals("admin")&&password.equals("admin")){
//            return "musicList";
//        }
//        else return "index";
        try {
            request.setCharacterEncoding("UTF-8");

            //获取密码
            String pw = userMapper.getPasswordByAccount(account);
            if(pw != null && pw.equals(password)) {
                //创建session对象
                HttpSession session = request.getSession();
                session.setAttribute("account",account);
                session.setAttribute("password",password);
                musicuser musicuser = userMapper.getUserByAccount(account);
                map.put("user",musicuser);
                System.out.println("map = " + map);
                //跳转至主页
                return "redirect:music/home";
            }else {
                //返回登陆页面，报告错误信息
            map.put("msg","用户名或密码错误！");
            return "index";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "index";
    }
//    @GetMapping("home")
//    public String home(){
//        return "musicList";
//    }

}
