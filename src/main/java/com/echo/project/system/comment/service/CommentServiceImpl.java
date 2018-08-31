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

/**
 * 评论Service实现类 将Comment和CommentReply合并   因为想要实现评论嵌套做了两个实现类
 */
@Service("commentService")

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentReplyMapper commentReplyMapper;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public Long addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    /**
     * 获取评论列表
     * @param articleId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Comment> getComment(Integer articleId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Comment> commentList = commentMapper.getComment(articleId);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    /**
     * 评论回复
     * @param commentReply
     * @return
     */
    @Override
    public Long addCommentReply(CommentReply commentReply) {
        return commentReplyMapper.addCommentReply(commentReply);
    }

    /**
     * 获取评论回复信息
     * @param userId
     * @return
     */
    @Override
    public List<CommentReply> getCommentReplyByUserId(Integer userId) {
        return commentReplyMapper.getCommentReplyByUserId(userId);
    }


}
