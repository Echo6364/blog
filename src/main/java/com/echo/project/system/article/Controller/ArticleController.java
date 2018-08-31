package com.echo.project.system.article.controller;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.service.ArticleService;
import com.echo.project.system.comment.domain.Comment;
import com.echo.project.system.comment.domain.CommentReply;
import com.echo.project.system.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/system/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/add")
    public String addArticle(Article article) {
        articleService.addArticle(article);
        return ("system/article/add");
    }

    /**
     * 获取文章列表 分页 默认分页 10篇每页
     * 右侧的点击排行
     * @param model
     * @return
     */
    @RequestMapping("/articlePage")
    public String articlePage(Model model) {
        int pageSize = 10;
        int currentPage = 1;
        List<Article> articleList = articleService.selectAllArticlePageInfo(currentPage, pageSize).getList();
        model.addAttribute("articleList", articleList);

        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView", articleListOrderByArticleView);
        return "system/article/articlePage";
    }

    /**
     * 文章列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/articleList")
    public String selectAllArticleByPage(Model model/**, @RequestParam("currentPage") int currentPage**/) {
        int pageSize = 10;
        int currentPage = 1;
        List<Article> articleList = articleService.selectAllArticlePageInfo(currentPage, pageSize).getList();
        model.addAttribute("articleList", articleList);
        return ("system/article/articleList");
    }

    /**
     * 根据点击数获取列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/articleListOrderByArticleView")
    public String articleListOrderByArticleView(Model model) {
        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView", articleListOrderByArticleView);
        return ("system/article/articlePage");
    }

    /**
     * 文章的详细信息 载入后包括初始化内容 获取评论 获取右侧的点击排行
     * @param articleId
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/details/{articleId}")
    public String articleDetails(@PathVariable("articleId") Integer articleId, Integer userId, Model model) {
        Article articleDetailsInfo = articleService.selectByArticleId(articleId);
        model.addAttribute("articleDetailsInfo", articleDetailsInfo);

        int pageSize = 5;
        int currentPage = 1;
        List<Comment> commentList = commentService.getComment(articleId, currentPage, pageSize).getList();
        model.addAttribute("commentList", commentList);

        List<Article> articleListOrderByArticleView = articleService.selectArticleOrderByArticleView();
        model.addAttribute("articleListOrderByArticleView", articleListOrderByArticleView);

        return ("system/article/details");
    }

}
