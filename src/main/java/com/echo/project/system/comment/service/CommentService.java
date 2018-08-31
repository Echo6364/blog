package com.echo.project.system.comment.service;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.domain.CommentReply;
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
