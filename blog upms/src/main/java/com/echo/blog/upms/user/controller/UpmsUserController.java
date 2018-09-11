package com.echo.blog.upms.user.controller;

import com.echo.blog.upms.shiro.service.PasswordEncrypt;
import com.echo.blog.upms.user.domain.UpmsUser;
import com.echo.blog.upms.user.service.UpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UpmsUserController {
    @Autowired
    UpmsUserService upmsUserService;
    @Autowired
    PasswordEncrypt passwordEncrypt;
    /**
     * 注册
     * @param upmsUser
     * @return
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(UpmsUser upmsUser) {
        upmsUserService.userSignUp(passwordEncrypt.encrypt(upmsUser));
        return "/login";
    }
}
