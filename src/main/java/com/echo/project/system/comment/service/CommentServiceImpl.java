package com.echo.project.system.comment.service;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Long addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
