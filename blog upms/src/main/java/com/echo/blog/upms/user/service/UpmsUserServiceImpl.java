package com.echo.blog.upms.user.service;

import com.echo.blog.common.constant.UserConstants;
import com.echo.blog.upms.user.domain.UpmsUser;
import com.echo.blog.upms.user.mapper.UpmsUserMapper;
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
@Service("upmsUserService")
public class UpmsUserServiceImpl implements UpmsUserService {
    @Autowired
    private UpmsUserMapper upmsUserMapper;

    /**
     * 用户注册
     * @param upmsUser
     * @return
     */
    @Override
    public Long userSignUp(UpmsUser upmsUser) {
        Date date = getNowDate();
        upmsUser.setLoginDate(date);
        upmsUser.setGmtCreate(date);
        upmsUser.setGmtModified(date);
        upmsUser.setRole("user");
        return upmsUserMapper.userSignUp(upmsUser);
    }

    /**
     * 检查登录信息是否唯一
     * @param loginId
     * @return
     */
    @Override
    public String checkLoginIdUnique(String loginId) {
        int count = upmsUserMapper.checkLoginIdUnique(loginId);
        if (count > 0) {
            return UserConstants.USER_ID_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public UpmsUser selectUserByUserName(String userName) {
        return null;
    }

    /**
     * 根据登录Id获取用户信息
     * @param loginId
     * @return
     */
    @Override
    public UpmsUser searchByLoginId(String loginId) {
        return upmsUserMapper.searchByLoginId(loginId);
    }

    /**
     * 根据登录Id获取权限信息
     * @param loginId
     * @return
     */
    @Override
    public String getRoleByLoginId(String loginId) {
        return upmsUserMapper.getRoleByLoginId(loginId);
    }


}
