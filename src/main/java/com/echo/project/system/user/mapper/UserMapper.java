package com.echo.project.system.user.mapper;

import com.echo.project.system.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    Long userSignUp(User user);

    int checkLoginIdUnique(String loginId);

    User searchByLoginId(String loginId);

    String getRoleByLoginId(String loginId);
}