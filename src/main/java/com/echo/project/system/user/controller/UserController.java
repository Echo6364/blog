package com.echo.project.system.user.controller;

import com.echo.common.shiro.Service.PasswordEncrypt;
import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncrypt passwordEncrypt;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(User user) {
        userService.userSignUp(passwordEncrypt.encrypt(user));
        return "/login";
    }

}
