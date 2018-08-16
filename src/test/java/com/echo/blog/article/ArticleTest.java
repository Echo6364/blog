package com.echo.blog.article;

import com.echo.BlogApplication;
import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.echo.project.system.user.service.UserService;
import com.echo.project.system.user.domain.User;
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
public class ArticleTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void articleSet() {
        Article article = new Article();
        Date date = getNowDate();
        article.setGmtCreate(date);
        article.setTitle("测试");
        article.setText("测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试");
       articleService.addArticle(article);
    }

}