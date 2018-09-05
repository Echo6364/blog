package com.echo.project.system.comment.mapper;

import com.echo.project.system.comment.domain.CommentReply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReplyMapper {
    /**
     * 添加评论回复
     * @param commentReply
     * @return
     */
    Long addCommentReply (CommentReply commentReply);

    /**
     * 获取评论
     * @param userId
     * @return
     */
    List<CommentReply> getCommentReplyByUserId(Integer userId);
}