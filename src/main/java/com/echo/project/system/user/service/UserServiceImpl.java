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
 * 2018-8-14
 * <p>
 * 接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册 并设定注册时间
     * @param user
     * @return
     */
    @Override
    public Long userSignUp(User user) {
        Date date = getNowDate();
        user.setLoginDate(date);
        user.setGmtCreate(date);
        user.setGmtModified(date);
        user.setRole("user");
        return userMapper.userSignUp(user);
    }

    /**
     * 检查登录ID是否唯一
     * @param loginId
     * @return
     */
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

    /**
     * 根据登录ID搜索用户信息
     * @param loginId
     * @return
     */
    @Override
    public User searchByLoginId(String loginId) {
        return userMapper.searchByLoginId(loginId);
    }

    /**
     * 根据登录Id获得权限信息
     * @param loginId
     * @return
     */
    @Override
    public String getRoleByLoginId(String loginId) {
        return userMapper.getRoleByLoginId(loginId);
    }

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
     * 获得用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserInfo(Integer userId) {
        return userMapper.getUserInfo(userId);
    }
}
