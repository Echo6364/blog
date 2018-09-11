package com.echo.blog.system.user.controller;

import com.echo.blog.system.user.domain.User;
import com.echo.blog.system.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户相关Controller
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    private String prifix = "/system/user";

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
