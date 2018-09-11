package com.echo.blog.system.article.service;

import com.echo.blog.system.article.domain.Article;
import com.echo.blog.system.article.mapper.ArticleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.echo.blog.common.utils.DateUtils.getNowDate;

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
     * 删除文章
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
     * 根据文章Id 获取文章
     * @param articleId
     * @return
     */
    @Override
    public Article selectByArticleId(Integer articleId) {
        return articleMapper.selectByArticleId(articleId);
    }

    /**
     * 根据点击量获取文章列表
     * @return
     */
    @Override
    public List<Article> selectArticleOrderByArticleView() {
        return articleMapper.selectArticleOrderByArticleView();
    }

    /**
     * 根据文章分类获取文章
     * @param sort
     * @return
     */
    @Override
    public List<Article> selectArticleBySort(String sort) {
        return selectArticleBySort(sort);
    }

    /**
     * 获取所有文章并使用PageHelper插件分页
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
     * 获取所有文章
     * @return
     */
    @Override
    public List<Article> selectAllArticle() {
        return articleMapper.selectAllArticle();
    }
}
