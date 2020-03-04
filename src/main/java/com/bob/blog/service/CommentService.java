package com.bob.blog.service;

import com.bob.blog.entity.Comment;

import java.util.List;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/5 19:08
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
