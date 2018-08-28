package com.echo.project.system.comment.service;

import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.article.domain.Article;
import com.echo.project.system.user.domain.User;
import org.springframework.stereotype.Service;

@Service("commentService")
public interface CommentService {
    Long addComment (Comment comment);
}
