package com.czw.blog.demo.service;


import com.czw.blog.demo.dao.CommentMapper;
import com.czw.blog.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.StringContent;
import java.util.List;

@Component
public class CommentServ {
    @Autowired
    CommentMapper commentMapper;

    public List<Comment> findAll(){
        return commentMapper.findAll();
    }

    public List<Comment> findByArticleId(Integer id){
       return commentMapper.selectByArticleId(id);
    }

    public int deleteByArticleId(Integer id){
        return commentMapper.deleteByArticleId(id);
    }

    public int addComment(String content, Integer pubid, Integer articleid){
        return commentMapper.insert(content,pubid,articleid);
    }

    public int update(String content, Integer id){
        return commentMapper.update(content,id);
    }

    public int delete(Integer id){
        return commentMapper.delete(id);
    }
}
