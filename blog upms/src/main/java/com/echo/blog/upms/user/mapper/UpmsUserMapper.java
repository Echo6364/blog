package com.echo.blog.upms.user.mapper;

import com.echo.blog.upms.user.domain.UpmsUser;
import org.springframework.stereotype.Repository;

public interface UpmsUserMapper {
    /**
 * 用户注册
 * @param
 * @return
 */
Long userSignUp(UpmsUser upmsUser);

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
    UpmsUser searchByLoginId(String loginId);

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
}
