package com.echo.project.system.article.mapper;

import com.echo.project.system.article.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    /**
     * 根据 文章的Id 删除文章
     * @param articleId
     * @return
     */
    int deleteArticleByArticleId(Integer articleId);

    /**
     * 添加文章
     * @param article
     * @return
     */
    Long addArticle(Article article);

    /**
     * 编辑文章
     * @param article
     * @return
     */
    Long editArticle(Article article);

    /**
     * 根据文章的Id获取单篇文章
     * @param articleId
     * @return
     */
    Article selectByArticleId(Integer articleId);

    /**
     * 根据点击数获取文章列表 ，Top5
     * @return
     */
    List<Article> selectArticleOrderByArticleView();

    /**
     * 根据文章分类获取文章
     * @param sort
     * @return
     */
    List<Article> selectArticleBySort(String sort);

    /**
     * 获取所有文章
     * @return
     */
    List<Article> selectAllArticle();

}