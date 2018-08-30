package com.echo.blog.comment;

import com.echo.BlogApplication;
import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.service.CommentService;
import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static com.echo.common.utils.DateUtils.getNowDate;

/**
 * Service层单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
@WebAppConfiguration
public class CommentTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setArticleId(1);
        comment.setContent("222222222222222222222222222222222222222222222222222222");
        commentService.addComment(comment);
    }

}