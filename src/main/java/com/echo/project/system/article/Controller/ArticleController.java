package com.echo.project.system.article.controller;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;

@Controller
@RequestMapping("/system/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/add")
    public String addArticle(Article article) {
        articleService.addArticle(article);
        return ("system/article/add");
    }

    @RequestMapping("/articlePage")
    public String articlePage(Model model){
        int pageSize = 10;
        int currentPage = 1;
        List<Article> articleList = articleService.selectAllArticlePageInfo(currentPage, pageSize).getList();
        model.addAttribute("articleList",articleList);

        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView",articleListOrderByArticleView);
        return "system/article/articlePage";
    }

    @RequestMapping(value = "/articleList")
    public String selectAllArticleByPage(Model model/**, @RequestParam("currentPage") int currentPage**/) {
        int pageSize = 10;
        int currentPage = 1;
        List<Article> articleList = articleService.selectAllArticlePageInfo(currentPage, pageSize).getList();
        model.addAttribute("articleList",articleList);
        return ("system/article/articleList");
    }

    @RequestMapping(value = "/articleListOrderByArticleView")
    public String articleListOrderByArticleView(Model model){
        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView",articleListOrderByArticleView);
        return ("system/article/articlePage");
    }

    @RequestMapping(value = "/details/*")
    public String articleDetails (@RequestParam Integer articleId, Model model) {
        Article articleDetailsInfo = articleService.selectByArticleId(articleId);
        model.addAttribute("articleDetailsInfo",articleDetailsInfo);

        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView",articleListOrderByArticleView);
        return ("system/article/details");
    }

}
