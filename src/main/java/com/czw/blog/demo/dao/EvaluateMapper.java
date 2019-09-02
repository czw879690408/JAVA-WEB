package com.czw.blog.demo.dao;

import com.czw.blog.demo.model.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EvaluateMapper {
    //查询所有
    @Select("select * from evaluate")
    public List<Comment> findAll();

    //根据ID查找
    @Select("select * from evaluate where id=#{id}")
    public Comment selectById(Integer id);

    //插入
    //说说点赞
    @Insert("INSERT INTO evaluate(fromId,type,toArticleId) VALUE (#{fromId},0,#{toId})")
    public int insertToArticle(Integer fromId,Integer type,Integer toId);

    //评论点赞
    @Insert("INSERT INTO evaluate(fromId,type,toCommentId) VALUE (#{fromId},1,#{toId})")
    public int insertToComment(Integer fromId,Integer type,Integer toId);

    //回复点赞
    @Insert("INSERT INTO evaluate(fromId,type,toReplyIdId) VALUE (#{fromId},2,#{toId})")
    public int insertToReply(Integer fromId,Integer type,Integer toId);

    //修改
    @Update("UPDATE comment SET content=#{content} WHERE id=#{id}")
    public int update(String content,Integer id);

    @Delete("DELETE  FROM comment WHERE id=#{id}")
    public int delete(Integer id);
}
