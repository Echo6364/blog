package com.echo.project.system.user.service;

import com.echo.project.system.user.domain.User;


public interface UserService {
    public Long userSignUp(User user);

    public String checkLoginIdUnique(String loginId);

    public int updateUser(User user);

    User selectUserByUserName(String userName);

    public User selectUserByEmail(String email);

    public User searchByLoginId(String loginId);

    public String getRoleByLoginId(String loginId);
}
