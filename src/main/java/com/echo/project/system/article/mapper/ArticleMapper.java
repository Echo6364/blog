package com.echo.project.system.article.mapper;

import com.echo.project.system.article.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteArticleByArticleId(Integer articleId);

    Long addArticle(Article article);

    Long editArticle(Article article);

    Article selectByArticleId(Integer articleId);

    List<Article> selectArticleOrderByReadNumber();

    List<Article> selectArticleBySort(String sort);

}