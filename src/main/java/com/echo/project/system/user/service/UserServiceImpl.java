package com.echo.project.system.user.service;

import com.echo.common.constant.UserConstants;
import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.echo.common.utils.DateUtils.getNowDate;

/**
 * @author echo
 * <p>
 * 2018-7-30
 * <p>
 * 接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Long userSignUp(User user) {
        Date date = getNowDate();
        user.setLoginDate(date);
        user.setGmtCreate(date);
        user.setGmtModified(date);
        user.setRole("user");
        return userMapper.userSignUp(user);
    }

    @Override

    public String checkLoginIdUnique(String loginId) {
        int count = userMapper.checkLoginIdUnique(loginId);
        if (count > 0) {
            return UserConstants.USER_ID_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public User selectUserByUserName(String userName) {
        return null;
    }

    @Override
    public User selectUserByEmail(String email) {
        return null;
    }

    @Override
    public User searchByLoginId(String loginId) {
        return userMapper.searchByLoginId(loginId);
    }

    @Override
    public String getRoleByLoginId(String loginId) {
        return userMapper.getRoleByLoginId(loginId);
    }
}
