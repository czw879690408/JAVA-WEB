package com.czw.blog.demo.service;

import com.czw.blog.demo.dao.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EvaluateServ {
    @Autowired
    EvaluateMapper evaluateMapper;

    //创建点赞对象
    //微博
    public int creatEvaluateForArticle(Integer fromId,Integer toId){
        return evaluateMapper.insertToArticle(fromId,0,toId);
    }
    //评论
    public int creatEvaluateForComment(Integer fromId,Integer toId){
        return evaluateMapper.insertToArticle(fromId,1,toId);
    }
    //回复
    public int creatEvaluateForReply(Integer fromId,Integer toId){
        return evaluateMapper.insertToArticle(fromId,2,toId);
    }
}
