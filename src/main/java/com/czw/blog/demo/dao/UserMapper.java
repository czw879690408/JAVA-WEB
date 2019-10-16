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
    public List<User> findAll();

    //查询普通用户
    @Select("select * from userr where type=1")
    public List<User> findCommon();

    //根据ID查找
    @Select("select * from userr where id=#{id}")
    public User selectById(Integer id);

    @Select("SELECT * FROM userr WHERE userAccound=#{accound}")
    public User selectByAccount(String accound);

    //插入
    @Insert("INSERT INTO userr(userName,userAccound,userPassword)" +
            " VALUE (#{userName},#{userAccound},#{userPassword})")
    public int insert(@Param("userName") String userName,@Param("userAccound") String userAccount,@Param("userPassword") String userPassword);
    @Insert("INSERT INTO userr(userName, userAccound, userPassword, userAge, userSex,type) VALUE (#{userName},#{userAccount},#{userPassword},#{userAge},#{userSex},#{type})")
    public int inserts(@Param("userName") String userName, @Param("userAccount")String userAccount, @Param("userPassword")String userPassword, @Param("userAge")Integer userAge,@Param("userSex")Integer userSex,@Param("type")Integer type);
    //修改
    @Update("UPDATE userr SET userName=#{name},userAge=#{age},userSex=#{sex},type=#{type} where id=#{id}")
    public int update(@Param("id") Integer id,@Param("name") String name,@Param("age") Integer age,@Param("sex") Integer sex,@Param("type") Integer type);

    @Delete("DELETE FROM userr WHERE id=#{id}")
    public int delete(Integer id);
}
