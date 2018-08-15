package com.echo.project.system.article.service;

import com.echo.project.system.article.domain.Article;

import java.util.List;

public interface ArticleService {
    public Long addArticle(Article article);

    public Long deleteArticleByArticleId(Integer articleId);

    public Long editArticle(Article article);

    public Article selectByArticleId(Integer articleId);

    public List<Article> selectArticleOrderByReadNumber();

    public List<Article> selectArticleBySort(String sort);

}
