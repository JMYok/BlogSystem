package com.bob.blog.service;

import com.bob.blog.entity.Blog;
import com.bob.blog.ov.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/2 13:13
 */
public interface BlogService {
    Blog getBlog(Long id);

    //编辑器转换为html
    Blog getAndConvert(Long id);

    //后台博客列表
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    //首页查询方法
    Page<Blog> listBlog(String query, Pageable pageable);

    //首页展示
    List<Blog> listRecommendBlogTop(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
