package com.echo.blog.system.comment.service;

import com.echo.blog.system.comment.domain.Comment;
import com.echo.blog.system.comment.domain.CommentReply;
import com.echo.blog.system.comment.mapper.CommentMapper;
import com.echo.blog.system.comment.mapper.CommentReplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
/**
 * 评论功能Service实现类
 */
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
     * 获取评论 并分页
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
     * 添加评论回复
     * @param commentReply
     * @return
     */
    @Override
    public Long addCommentReply(CommentReply commentReply) {
        return commentReplyMapper.addCommentReply(commentReply);
    }

    /**
     * 获取评论回复列表
     * @param userId
     * @return
     */
    @Override
    public List<CommentReply> getCommentReplyByUserId(Integer userId) {
        return commentReplyMapper.getCommentReplyByUserId(userId);
    }


}
