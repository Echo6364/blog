package com.echo.project.monitor.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页的跳转
 */
@Controller
public class BaseController {
    @RequestMapping("/index")
    public String HomePage() {
        return ("/index");
    }
}
