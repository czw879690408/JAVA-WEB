package com.czw.music.dao;


import com.czw.music.enrity.music;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface MusicMapper {

    //获取所有歌曲
    @Select("select * from music")
    public List<music> findAll();

    //添加音乐
    @Insert("insert into music(musicName,musicDirectory,musicType) value(#{name},#{directory},#{type})")
    public int insertMusic(@Param("name") String name,@Param("directory") String directory, @Param("type") Integer type);

}

