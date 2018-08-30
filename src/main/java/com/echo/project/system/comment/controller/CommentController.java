package com.echo.project.system.comment.controller;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/system/article")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/details/addComment")
    public String addComment(Integer articleId, Comment comment) {
        articleId = Integer.valueOf(articleId);
        comment.setArticleId(articleId);
        commentService.addComment(comment);
        return "system/article/details/addComment";
    }

    @RequestMapping
    public String addCommentReply(Integer articleId, Comment comment) {
        articleId = Integer.valueOf(articleId);
        return null;
    }

    @RequestMapping("/details/Comment/{articleId}")
    public String getComment(Model model, @PathVariable Integer articleId) {
        int pageSize = 10;
        int currentPage = 1;
        List<Comment> commentList = commentService.getComment(articleId, currentPage, pageSize).getList();
        model.addAttribute("commentList", commentList);

        return "system/article/details";
    }
}


