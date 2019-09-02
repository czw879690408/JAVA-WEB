package com.czw.music.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping("/user")
@Controller
public class UserCon {
    @GetMapping("/main")
    public String main(){
        return "musicList";
    }
}
