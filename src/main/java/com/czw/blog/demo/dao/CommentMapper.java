package com.czw.blog.demo.dao;

import com.czw.blog.demo.model.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    //查询所有
    @Select("select * from comment")
    public List<Comment> findAll();

    //根据ID查找
    @Select("select * from comment where id=#{id}")
    public Comment selectById(Integer id);

    @Select("select * from comment where articleId=#{id}")
    public List<Comment> selectByArticleId(Integer id);

    @Select("SELECT * FROM comment WHERE pubId=#{id}")
    public List<Comment> selectByPubId(Integer id);

    //插入
    @Insert("INSERT INTO comment(content,pubId,articleId,likenum) VALUE (#{content},#{pubId},#{articleId},0)")
    public int insert(@Param("content") String content, @Param("pubId") Integer pubId, @Param("articleId") Integer articleId);

    //修改
    @Update("UPDATE comment SET content=#{content} WHERE id=#{id}")
    public int update(@Param("content") String content, @Param("id") Integer id);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    public int delete(Integer id);

    @Delete("DELETE FROM comment WHERE articleId=#{id}")
    public int deleteByArticleId(Integer id);
}
