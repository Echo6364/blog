package com.echo.project.system.user.controller;

import com.echo.common.shiro.Service.PasswordEncrypt;
import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户相关Controller
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncrypt passwordEncrypt;

    private String prifix = "/system/user";

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(User user) {
        userService.userSignUp(passwordEncrypt.encrypt(user));
        return "/login";
    }

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @RequestMapping(value ="/system/user/edit")
    public String editUserInfo(User user){
        userService.editUserInfo(user);
        return "info";
    }

    /**
     * 获取用户信息
     * @param model
     * @return
     */
    // SecurityUtils.getSubject().getPrincipal()获取到的是 shiroRealm里 doGetAuthenticationInfo 即身份验证的 SimpleAuthenticationInfo 第一个参数
    @RequestMapping(value = "/system/user/info" )
    public String competitorPageList(Model model) {
        String loginId=(String) SecurityUtils.getSubject().getPrincipal();
        User userInfo = userService.getUserInfo(loginId);
        model.addAttribute("userInfo",userInfo);
        return "system/user/info";
    }

}
