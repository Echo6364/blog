package com.echo.blog.upms.user.service;

import com.echo.blog.upms.user.domain.UpmsUser;

/**
 * UserService相关接口类
 */
public interface UpmsUserService {
    public Long userSignUp(UpmsUser upmsUser);

    public String checkLoginIdUnique(String loginId);

    UpmsUser selectUserByUserName(String userName);

    public UpmsUser searchByLoginId(String loginId);

    public String getRoleByLoginId(String loginId);

}
