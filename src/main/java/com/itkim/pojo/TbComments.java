package com.itkim.pojo;

import lombok.ToString;

@ToString
public class TbComments {
    private Long commentid;

    private Long songid;

    private Long userid;

    private String nickname;

    private Integer likedcount;

    private String comment;

    private Long time;

    private String avatarurl;

    private Integer ishotcomments;

    private Integer commentnum;

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public Long getSongid() {
        return songid;
    }

    public void setSongid(Long songid) {
        this.songid = songid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getLikedcount() {
        return likedcount;
    }

    public void setLikedcount(Integer likedcount) {
        this.likedcount = likedcount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Integer getIshotcomments() {
        return ishotcomments;
    }

    public void setIshotcomments(Integer ishotcomments) {
        this.ishotcomments = ishotcomments;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

}