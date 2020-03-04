package com.bob.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String title;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String firstPicture; //首图
    private String flag;//是否原创
    private Integer views;
    private boolean appreciation;//赞赏
    private boolean shareStatement;//博客维权
    private boolean commentabled;//评论
    private boolean published;//是否发布
    private boolean recommend;//是否推荐
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade ={CascadeType.PERSIST} )//创建级联
    private List<Tag> tags = new ArrayList<>();

    @Transient
    private String tagIds;

    private String description;

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    //获取ids 1,2,3,4...
    private String tagsToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag : tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.DETACH,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }


    public Blog(String title, String content, String firstPicture, String flag, Integer views, boolean appreciation, boolean shareStatement, boolean commentabled, boolean published, boolean recommend, Date createTime, Date updateTime, Type type, List<Tag> tags, String tagIds, String description, User user, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = views;
        this.appreciation = appreciation;
        this.shareStatement = shareStatement;
        this.commentabled = commentabled;
        this.published = published;
        this.recommend = recommend;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.tags = tags;
        this.tagIds = tagIds;
        this.description = description;
        this.user = user;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", tags=" + tags +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
