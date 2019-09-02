package com.czw.blog.demo.model;



public class Reply {
    private Integer id;             //主键ID
    private Integer articleId;      //文章ID
    private String  content;        //内容
    private Integer fromId;         //发布者ID
    private Integer toId;           //评论发布者ID
    private Integer commentId;      //对应评论ID
    private Integer likenum;

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", commentId=" + commentId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
