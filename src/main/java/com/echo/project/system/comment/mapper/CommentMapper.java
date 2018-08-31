package com.echo.project.system.comment.mapper;

import com.echo.project.system.comment.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论Mapper接口类
 */
@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    Long addComment(Comment comment);

    List<Comment> getComment(Integer articleId);
}