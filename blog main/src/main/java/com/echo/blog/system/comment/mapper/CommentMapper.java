package com.echo.blog.system.comment.mapper;

import com.echo.blog.system.comment.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    Long addComment(Comment comment);

    /**
     * 获取评论
     * @param articleId
     * @return
     */
    List<Comment> getComment(Integer articleId);
}