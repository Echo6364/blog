package com.echo.blog.system.article.service;

import com.echo.blog.system.article.domain.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * ArticleService 接口类
 */
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
