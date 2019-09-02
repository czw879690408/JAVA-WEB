package com.czw.blog.demo.controller;

import com.czw.blog.demo.dao.ArticleMapper;
import com.czw.blog.demo.dao.UserMapper;
import com.czw.blog.demo.model.Article;
import com.czw.blog.demo.model.User;
import com.czw.blog.demo.service.ArticleServ;
import com.czw.blog.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("/home")
@Controller
public class HomeCon {

    @Autowired
    ArticleServ     articleServ;


    @Autowired
    UserServ        userServ;

    //主页
    @GetMapping("")
    public String home(Map<String, Object> map , HttpServletRequest request){
        //获取Session里的user
        User user = (User)request.getSession().getAttribute("user");
        //获取所有微博
        List<Article> articles = articleServ.findAll();
        Collections.reverse(articles);
//        System.out.println("articles = " + articles);
        //存储文章相关的用户
        Map<Integer,Object> users = new HashMap<>();
        //存储用户ID
        Set<Integer> set = new HashSet<Integer>();
        //遍历获取用户ID
        for (Article article:articles) {
            System.out.println("articleid:"+article.getId());
            set.add(article.getPubId());
        }
        //获取用户
        for (Integer i:set){
            System.out.println("i:"+i);
            users.put(i,userServ.selectById(i));
        }

        map.put("user",user);
        System.out.println("user:" + user);
        map.put("users",users);
        System.out.println("users = " + users.get(1));
        map.put("articles",articles);
        System.out.println("articles = " + articles);
        return "homes";
    }
}
