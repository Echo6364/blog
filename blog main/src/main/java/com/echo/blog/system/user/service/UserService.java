package com.echo.blog.system.user.service;

import com.echo.blog.system.user.domain.User;

/**
 * UserService相关接口类
 */
public interface UserService {

    public Long editUserInfo(User user);

    public User getUserInfo(String loginId);
}
