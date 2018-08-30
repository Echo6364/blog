package com.echo.project.system.comment.controller;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @RequestMapping("/details/comment")
//    public String getComment(Model model, Integer articleId) {
//
//
//        return "system/article/details";
//    }
}


