package com.echo.comment.mapper;

import com.echo.comment.domain.CommentReply;
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