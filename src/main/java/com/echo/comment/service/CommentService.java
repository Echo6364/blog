package com.echo.comment.service;

public interface CommentService {
    Long addComment (String userId, String articleId, String articleType);
}
