package com.echo.project.system.comment.mapper;

import com.echo.project.system.comment.domain.CommentReply;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    CommentReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKey(CommentReply record);
}