package com.echo.project.system.comment.controller;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.domain.CommentReply;
import com.echo.project.system.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/article")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 添加评论
     * @param articleId
     * @param comment
     * @return
     */
    @RequestMapping(value = "/details/addComment")
    public String addComment(Integer articleId, Comment comment) {
        articleId = Integer.valueOf(articleId);
        comment.setArticleId(articleId);
        commentService.addComment(comment);
        return "system/article/details/addComment";
    }

    /**
     * 添加评论回复
     * @param articleId
     * @param commentReply
     * @return
     */
    @RequestMapping(value = "/details/addCommentReply")
    public String addCommentReply(Integer articleId, CommentReply commentReply) {
        articleId = Integer.valueOf(articleId);
        commentReply.setArticleId(articleId);
        commentService.addCommentReply(commentReply);
        return "system/article/details/addCommentReply";
    }
}


