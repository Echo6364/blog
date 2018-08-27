package com.echo.project.system.article.service;

import com.echo.project.system.article.domain.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {
    public Long addArticle(Article article);

    public Long deleteArticleByArticleId(Integer articleId);

    public Long editArticle(Article article);

    public Article selectByArticleId(Integer articleId);

    public List<Article> selectArticleOrderByArticleView();

    public List<Article> selectArticleBySort(String sort);

    public PageInfo<Article> selectAllArticlePageInfo(int currentPage, int pageSize);

    public List<Article> selectAllArticle();

}
