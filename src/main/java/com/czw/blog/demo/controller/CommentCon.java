package com.czw.blog.demo.controller;

import com.czw.blog.demo.model.Article;
import com.czw.blog.demo.model.Comment;
import com.czw.blog.demo.model.Reply;
import com.czw.blog.demo.model.User;
import com.czw.blog.demo.service.ArticleServ;
import com.czw.blog.demo.service.CommentServ;
import com.czw.blog.demo.service.ReplyServ;
import com.czw.blog.demo.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("comment")
public class CommentCon {

    @Autowired
    ArticleServ articleServ;

    @Autowired
    CommentServ commentServ;

    @Autowired
    UserServ userServ;

    @Autowired
    ReplyServ replyServ;


    //进入页面
    @GetMapping("")
    public String comment(@RequestParam("id") Integer id, Map<String,Object> map){
        Article article = articleServ.findById(id);
        User user = userServ.selectById(article.getPubId());
        List<Comment> comments = commentServ.findByArticleId(article.getId());
        Map<Integer,Object> users = new HashMap<>();


        //存储用户ID
        Set<Integer> set = new HashSet<Integer>();
        //遍历获取用户ID
        for (Comment comment:comments) {
            System.out.println("articleid:"+comment.getId());
            set.add(comment.getPubId());
        }
        //获取用户
        for (Integer i:set){
            System.out.println("i:"+i);
            users.put(i,userServ.selectById(i));
        }


        map.put("article",article);
        map.put("user",user);
        map.put("users",users);
        map.put("comments",comments);

        return "comment";
    }

    //添加评论

    @PostMapping("adds")
    public String addComment(@RequestParam("contnent") String content,
                           @RequestParam("articleid") Integer articleid,
                           Map<String,Object> map,
                           HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        commentServ.addComment(content,user.getId(),articleid);
        articleServ.commentNumIncrease(articleid);
        String url = "../comment/?id=" + articleid;
        return "redirect:" + url;
    }
    //添加回复
    @PostMapping("reply/add")
    public String addReply(@RequestParam("replycontent") String content,
                           @RequestParam("articleid")   Integer article,
                           @RequestParam("fromid")      Integer fromid,
                           @RequestParam("toid")        Integer toid,
                           @RequestParam("commentid")   Integer commentid){
        replyServ.addReply(article,fromid,toid,commentid,content);
        return "forward: comment";
    }
}
