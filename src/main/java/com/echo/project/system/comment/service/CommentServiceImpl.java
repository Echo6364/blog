package com.echo.project.system.comment.service;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.domain.CommentReply;
import com.echo.project.system.comment.mapper.CommentMapper;
import com.echo.project.system.comment.mapper.CommentReplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    CommentReplyMapper commentReplyMapper;

    @Override
    public Long addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public PageInfo<Comment> getComment(Integer articleId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Comment> commentList = commentMapper.getComment(articleId);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    @Override
    public Long addCommentReply(CommentReply commentReply) {
        return commentReplyMapper.addCommentReply(commentReply);
    }


}
