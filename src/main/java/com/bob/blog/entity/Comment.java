package com.bob.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private boolean adminComment;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment",fetch = FetchType.EAGER,cascade = CascadeType.DETACH,orphanRemoval = true)
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

    public Comment() {
    }

    public Comment(String nickname, String email, String content, String avatar, Date createTime) {
        this.nickname = nickname;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", adminComment=" + adminComment +
                ", blog=" + blog +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                '}';
    }
}
