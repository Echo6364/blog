package com.echo.project.system.article.Controller;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/add")
    public String addArticle(Article article){
        articleService.addArticle(article);
        return("/system/article/add");
    }
}
