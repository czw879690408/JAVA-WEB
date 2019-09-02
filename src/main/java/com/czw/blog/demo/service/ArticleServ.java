package com.czw.blog.demo.service;


import com.czw.blog.demo.dao.ArticleMapper;
import com.czw.blog.demo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class ArticleServ {
    @Autowired
    ArticleMapper articleMapper;

    public int addArticle(String content, Integer pubid){
        java.util.Date utilDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
       return articleMapper.insert(content,sqlDate,pubid);
    }

    public int deleteArticle(Integer id){
        return articleMapper.deleteArticleById(id);
    }

    public List<Article> findAll(){
        return articleMapper.findAll();
    }

    public Article findById(Integer id){
        return articleMapper.selectById(id);
    }

    public void commentNumIncrease(Integer id){
        articleMapper.updateCommentNum(articleMapper.selectById(id).getCommentNum()+1,id);
    }

    public void likenumIncrease(Integer id){
        articleMapper.updateLikenum(articleMapper.selectById(id).getLikenum()+1,id);
    }

}
