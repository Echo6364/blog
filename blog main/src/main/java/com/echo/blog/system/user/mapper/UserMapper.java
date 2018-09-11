package com.echo.blog.system.user.mapper;

import com.echo.blog.system.user.domain.User;
import org.springframework.stereotype.Repository;

/**
 * User相关的Dao接口
 */
@Repository
public interface UserMapper {
    /**
     * 用户注册
     * @param user
     * @return
     */
    Long userSignUp(User user);

    /**
     * 检查登录名是否重复
     * @param loginId
     * @return
     */
    int checkLoginIdUnique(String loginId);

    /**
     * 根据登录账号查询用户信息
     * @param loginId
     * @return
     */
    User searchByLoginId(String loginId);

    /**
     * 根据用户名获取权限信息
     * @param loginId
     * @return
     */
    String getRoleByLoginId(String loginId);

    /**编辑用户信息
     *
     * @param user
     * @return
     */
    Long editUserInfo(User user);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    User getUserInfo(String userId);
}