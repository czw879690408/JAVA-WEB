package com.czw.blog.demo.dao;

import com.czw.blog.demo.model.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReplyMapper {
    //查询所有
    @Select("select * from reply")
    public List<Comment> findAll();

    //根据ID查找
    @Select("select * from reply where id=#{id}")
    public Comment selectById(Integer id);

    //插入
    @Insert("INSERT INTO reply(articleId, content, fromId, toId, commentId,likenum)" +
            " VALUE (#{articleId},#{content},#{fromId},#{toId},#{commentId},0)")
    public int insert(Integer articleId,String content,Integer fromId,Integer toId,Integer commentId);

    //修改
    @Update("UPDATE reply SET content=#{content} WHERE id=#{id}")
    public int update(String content,Integer id);

    @Delete("DELETE FROM reply WHERE id=#{id}")
    public int delete(Integer id);
}
