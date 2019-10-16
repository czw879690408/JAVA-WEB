package com.czw.blog.demo.controller;

import com.czw.blog.demo.dao.ArticleMapper;
import com.czw.blog.demo.service.ArticleServ;
import com.czw.blog.demo.service.EvaluateServ;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("article")
public class ArticleCon {
    @Autowired
    ArticleServ articleServ;

    @Autowired
    EvaluateServ evaluateServ;


    //进入添加页面
    @GetMapping("add")
    public String addArticle(@RequestParam("pubid") Integer pubid, Map<String,Object> map){
        map.put("pubid",pubid);
        return "addArticle";
    }

    //删除微博
    @PostMapping("delete")
    public String deleteArticle(@RequestParam("id") Integer id){
        articleServ.deleteArticle(id);
        return "redirect:../home";
    }

    //添加微博
    @PostMapping("add")
    public String insertArticle(@RequestParam("content")String content, @RequestParam("pubid")Integer pubid){
        articleServ.addArticle( content,pubid);
        return "redirect:../home";
    }

    //点赞+1
    @PostMapping("like")
    public void addLikenum(@RequestParam("articleid") Integer articleid,
                             @RequestParam("fromid") Integer fromid){
        System.out.println("like add...");
        evaluateServ.creatEvaluateForArticle(fromid,articleid);
        articleServ.likenumIncrease(articleid);
//        return "../homes";
    }

}
