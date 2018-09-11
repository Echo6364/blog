package com.echo.blog.system.comment.service;

import com.echo.blog.system.comment.domain.Comment;
import com.echo.blog.system.comment.domain.CommentReply;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 评论Service接口类
 */
public interface CommentService {
    Long addComment(Comment comment);

    PageInfo<Comment> getComment(Integer articleId, int currentPage, int pageSize);

    Long addCommentReply(CommentReply commentReply);

    List<CommentReply> getCommentReplyByUserId (Integer userId);
}
