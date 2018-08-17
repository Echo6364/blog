package com.echo.blog.user;

import com.echo.BlogApplication;
import com.echo.project.system.user.domain.User;
import com.echo.project.system.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static com.echo.common.utils.DateUtils.getNowDate;

/**
 * Service层单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogApplication.class)
@WebAppConfiguration
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void userSignUp() {
        User user = new User();
        Date date = getNowDate();
        user.setLoginDate(date);
        user.setGmtCreate(date);
        user.setGmtModified(date);
        user.setLoginId("admin");
        user.setLoginPassword("123456");
        user.setUserName("admin");
        user.setRole("admin");
        userService.userSignUp(user);
    }

}