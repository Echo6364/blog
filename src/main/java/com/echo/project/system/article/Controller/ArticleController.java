package com.echo.project.system.article.Controller;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/system/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/add")
    public String addArticle(Article article) {
        articleService.addArticle(article);
        return ("/system/article/add");
    }

    @RequestMapping(value = "/articleList")
    public String selectAllArticleByPage(Model model/**, @RequestParam("currentPage") int currentPage**/) {
        int pageSize = 10;
        int currentPage = 1;
        List<Article> articleList = articleService.selectAllArticlePageInfo(currentPage, pageSize).getList();
        model.addAttribute("articleList",articleList);
        return ("/system/article/articleList");
    }
}
