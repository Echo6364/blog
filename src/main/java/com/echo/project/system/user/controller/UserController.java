package com.echo.project.system.user.controller;

import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static com.echo.common.utils.DateUtils.getNowDate;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(User user, @RequestParam("loginId") String loginId,@RequestParam("loginPassword") String loginPassword,@RequestParam("userName") String userName, @RequestParam("Email") String Email){
        Date date = getNowDate();
        user.setLoginDate(date);
        user.setGmtCreate(date);
        user.setGmtModified(date);
        user.setLoginId(loginId);

    }

}
