package com.czw.blog.demo.model;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Article {
    private Integer id;
    private String  content;
    private Date    creatTime;
    private Integer pubId;
    private Integer likenum;
    private Integer commentNum;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creatTime=" + creatTime +
                ", pubId=" + pubId +
                ", likenum=" + likenum +
                ", commentNum=" + commentNum +
                '}';
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getPubId() {
        return pubId;
    }

    public void setPubId(Integer pubId) {
        this.pubId = pubId;
    }
}
