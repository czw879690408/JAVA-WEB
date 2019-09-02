package com.czw.music.dao;


import com.czw.music.enrity.musicuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao
 */
@Repository
@Mapper
public interface UserMapper {
    //查询所有
    @Select("select * from musicuser")
    public List<musicuser> findAll();


//    通过账号查询密码
    @Select("select userPassword from musicuser where userAccount=#{account}")
    public String getPasswordByAccount(String account);

    //通过账号密码获取账号
    @Select("select * from musicuser where userAccount=#{account} and userPassword=#{password}")
    public musicuser getUserByAccountAndPassword(String account,String password);

    @Select("select * from musicuser where userAccount=#{account}")
    public musicuser getUserByAccount(String account);

    //通过ID获取账号信息
    @Select("select * from musicuser where id=#{id}")
    public musicuser getUserById(Integer id);

    //添加用户


    //删除用户


    //修改用户信息

}
