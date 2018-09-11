package com.echo.blog.upms.user.controller;

import com.echo.blog.upms.shiro.service.PasswordEncrypt;
import com.echo.blog.common.utils.ServletUtils;
import com.echo.blog.common.utils.StringUtils;
import com.echo.blog.common.framework.web.domain.AjaxResult;
import com.echo.blog.upms.user.domain.UpmsUser;
import com.echo.blog.upms.user.service.UpmsUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录验证-shiro
 *
 * @author echo
 */
@RequestMapping
@Controller
public class LoginController {
    @Autowired
    private PasswordEncrypt passwordEncrypt;

    @Autowired
    private UpmsUserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest((HttpServletRequest) request)) {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String loginId, String loginPassword, Boolean rememberMe) {

        UpmsUser user = userService.searchByLoginId(loginId);
        String CredentialsSalt = user.getCredentialsSalt();
        loginPassword = passwordEncrypt.md5Pwd(loginPassword, CredentialsSalt);

        UsernamePasswordToken token = new UsernamePasswordToken(loginId, loginPassword, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return AjaxResult.error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth() {
        return "/error/unauth";
    }
}
