package com.echo.project.system.user.mapper;

import com.echo.project.system.user.domain.User;
import org.springframework.stereotype.Repository;

/**
 * User数据库接口类
 */
@Repository
public interface UserMapper {

    Long userSignUp(User user);

    int checkLoginIdUnique(String loginId);

    User searchByLoginId(String loginId);

    String getRoleByLoginId(String loginId);

    Long editUserInfo(User user);

    User getUserInfo(Integer userId);
}