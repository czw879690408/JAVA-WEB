package com.czw.blog.demo.service;

import com.czw.blog.demo.dao.ArticleMapper;
import com.czw.blog.demo.dao.CommentMapper;
import com.czw.blog.demo.dao.UserMapper;
import com.czw.blog.demo.model.Article;
import com.czw.blog.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServ {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public List<User> findCommon(){
        return userMapper.findCommon();
    }

    public User selectById(Integer id){
        return userMapper.selectById(id);
    }

    public User selectByAccount(String account){
        return userMapper.selectByAccount(account);
    }

    public int  insertUser(String userName,String userAccount,String userPassword){
       return userMapper.insert(userName,userAccount,userPassword);
    }

    public int insertUsers(String userName, String userAccount,String userPassword,Integer userAge,Integer userSex,Integer type){
       return userMapper.inserts(userName,userAccount,userPassword,userAge,userSex,type);
    }

    public int deleteUser(Integer id){
        List<Article> article = articleMapper.selectByPubId(id);
        for (Article a : article) {
            commentMapper.deleteByArticleId(a.getId());
            articleMapper.deleteArticleById(a.getId());
        }
        return userMapper.delete(id);
    }

    public int updateUser(Integer id,String name,Integer age,Integer sex,Integer type){
        return userMapper.update(id,name,age,sex,type);
    }
}
