package com.czw.blog.demo.dao;

import com.czw.blog.demo.model.Comment;
import com.czw.blog.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserMapper {
    //查询所有
    @Select("select * from userr")
    public List<Comment> findAll();

    //根据ID查找
    @Select("select * from userr where id=#{id}")
    public User selectById(Integer id);

    @Select("SELECT * FROM userr WHERE userAccound=#{accound}")
    public User selectByAccount(String accound);

    //插入
    @Insert("INSERT INTO userr(userName,userAccound,userPassword)" +
            " VALUE (#{userName},#{userAccound},#{userPassword})")
    public int insert(@Param("userName") String userName,@Param("userAccound") String userAccount,@Param("userPassword") String userPassword);

    //修改
    @Update("UPDATE userr SET content=#{content} WHERE id=#{id}")
    public int update(String content,Integer id);

    @Delete("DELETE FROM userr WHERE id=#{id}")
    public int delete(Integer id);
}
