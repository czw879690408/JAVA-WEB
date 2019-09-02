package com.czw.blog.demo.dao;

import com.czw.blog.demo.model.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
@Component
public interface ArticleMapper {

    //查询所有
    @Select("select * from article")
    public List<Article> findAll();


    //通过作者ID查询
    @Select("select * from article where pubId=#{id}")
    public  List<Article>  selectByPubId(Integer id);

    //通过ID查询
    @Select("select * from article where id=#{id}")
    public Article  selectById(Integer id);

    //添加
    @Insert("insert into article(content,creatTime,pubId,likenum,commentNum) value(#{content},#{creatTime},#{pubId},0,0)")
    public int  insert(@Param("content") String content ,@Param("creatTime") Date date,@Param("pubId") Integer pubId);

    //修改评论数
    @Update("UPDATE article SET commentNum=#{commentNum} WHERE id=#{id}")
    public int updateCommentNum(@Param("commentNum") Integer commentNum,@Param("id") Integer id);

    @Update("UPDATE article SET likenum=#{likenum} WHERE id=#{id}")
    public int updateLikenum(@Param("likenum") Integer commentNum,@Param("id") Integer id);

    //删除
    @Delete("delete from article where id=#{id}")
    public int  deleteArticleById(Integer id);

    //修改内容
    @Update("update article set content=#{content} where id=#{id}")
    public int  update(String content,Integer id);
}
