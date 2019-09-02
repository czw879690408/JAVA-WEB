package com.czw.blog.demo.service;

import com.czw.blog.demo.dao.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplyServ {
    @Autowired
    ReplyMapper replyMapper;

    //添加回复
    public int addReply(Integer articleid, Integer fromid, Integer toid, Integer commentid, String content){
       return replyMapper.insert(articleid,content,fromid,toid,commentid);
    }
}
