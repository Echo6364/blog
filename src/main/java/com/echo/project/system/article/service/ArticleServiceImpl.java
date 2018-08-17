package com.echo.project.system.article.service;

import com.echo.project.system.article.domain.Article;
import com.echo.project.system.article.mapper.ArticleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.echo.common.utils.DateUtils.getNowDate;

/**
 * @author echo
 * <p>
 * 2018-8-15
 * <p>
 * 接口实现类
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
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

    @Override
    public PageInfo<Article> selectAllArticlePageInfo(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Article> articleList = articleMapper.selectAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }
}
