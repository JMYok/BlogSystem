package com.bob.blog.web;

import com.bob.blog.entity.Comment;
import com.bob.blog.entity.User;
import com.bob.blog.service.BlogService;
import com.bob.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/5 19:04
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;
    //用户图片
    @Value("${comment.avatar}")
    private String avatar;

    /**
     * 得到评论列表
     * @param blogId
     * @param model
     * @return
     */
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "pages/blog :: commentList";
    }

    /**
     * 提交评论
     * @param comment
     * @param session
     * @return
     */
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));

        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}
