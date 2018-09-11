package com.echo.blog.system.user.service;

import com.echo.blog.common.constant.UserConstants;
import com.echo.blog.system.user.domain.User;
import com.echo.blog.system.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.echo.blog.common.utils.DateUtils.getNowDate;

/**
 * @author echo
 * <p>
 * 2018-8-14
 * <p>
 * 接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @Override
    public Long editUserInfo(User user) {
        Date date = getNowDate();
        user.setGmtModified(date);
        return userMapper.editUserInfo(user);
    }

    /**
     * 获取用户信息
     * @param loginId
     * @return
     */
    @Override
    public User getUserInfo(String loginId) {
        return userMapper.getUserInfo(loginId);
    }
}
