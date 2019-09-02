package com.czw.blog.demo.model;

public class Evaluate {
    private Integer id;
    private Integer fromId;
    private Integer toArticleId;
    private Integer toCommentId;
    private Integer toReplyId;
    private Integer type;

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", likenum=" +
                ", fromId=" + fromId +
                ", toArticleId=" + toArticleId +
                ", toCommentId=" + toCommentId +
                ", toReplyId=" + toReplyId +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToArticleId() {
        return toArticleId;
    }

    public void setToArticleId(Integer toArticleId) {
        this.toArticleId = toArticleId;
    }

    public Integer getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Integer toCommentId) {
        this.toCommentId = toCommentId;
    }

    public Integer getToReplyId() {
        return toReplyId;
    }

    public void setToReplyId(Integer toReplyId) {
        this.toReplyId = toReplyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
