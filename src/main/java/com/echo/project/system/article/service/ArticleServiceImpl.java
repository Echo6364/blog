package com.echo.project.system.article.service;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.echo.common.utils.DateUtils.getNowDate;

/**
 * @author echo
 *
 * 2018-8-15
 *
 * 接口实现类
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Long addArticle(Article article) {
        Date date = getNowDate();
        article.setGmtCreate(date);
        return articleMapper.addArticle(article);
    }

    @Override
    public Long deleteArticleByArticleId(Integer articleId) {
        return null;
    }

    @Override
    public Long editArticle(Article article) {
        Date date = getNowDate();
        article.setGmtModify(date);
        return articleMapper.editArticle(article);
    }

    @Override
    public Article selectByArticleId(Integer articleId) {
        return null;
    }

    @Override
    public List<Article> selectArticleOrderByReadNumber() {
        return articleMapper.selectArticleOrderByReadNumber();
    }

    @Override
    public List<Article> selectArticleBySort(String sort) {
        return selectArticleBySort(sort);
    }
}
