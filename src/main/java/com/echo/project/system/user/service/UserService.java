package com.echo.project.system.user.service;

import com.echo.project.system.user.domain.User;

/**
 * UserService相关接口类
 */
public interface UserService {
    public Long userSignUp(User user);

    public String checkLoginIdUnique(String loginId);

    public int updateUser(User user);

    User selectUserByUserName(String userName);

    public User selectUserByEmail(String email);

    public User searchByLoginId(String loginId);

    public String getRoleByLoginId(String loginId);

    public Long editUserInfo(User user);

    public User getUserInfo(String loginId);
}
