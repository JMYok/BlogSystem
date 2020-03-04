package com.bob.blog.dao;

import com.bob.blog.entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/5 19:10
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

}
