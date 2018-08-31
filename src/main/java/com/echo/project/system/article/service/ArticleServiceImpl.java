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

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public Long addArticle(Article article) {
        Date date = getNowDate();
        article.setGmtCreate(date);
        return articleMapper.addArticle(article);
    }

    /**
     *
     * @param articleId
     * @return
     */
    @Override
    public Long deleteArticleByArticleId(Integer articleId) {
        return null;
    }

    /**
     * 编辑文章
     * @param article
     * @return
     */
    @Override
    public Long editArticle(Article article) {
        Date date = getNowDate();
        article.setGmtModify(date);
        return articleMapper.editArticle(article);
    }

    /**
     * 获取单篇文章
     * @param articleId
     * @return
     */
    @Override
    public Article selectByArticleId(Integer articleId) {
        return articleMapper.selectByArticleId(articleId);
    }

    /**
     * 根据点击数 排行  5篇
     * @return
     */
    @Override
    public List<Article> selectArticleOrderByArticleView() {
        return articleMapper.selectArticleOrderByArticleView();
    }

    /**
     * 根据分类获取文章列表
     * @param sort
     * @return
     */
    @Override
    public List<Article> selectArticleBySort(String sort) {
        return selectArticleBySort(sort);
    }

    /**
     *获取所有文章并分页 使用PageHelper
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Article> selectAllArticlePageInfo(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Article> articleList = articleMapper.selectAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    /**
     * 选择所有文章
     * @return
     */
    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }
}
