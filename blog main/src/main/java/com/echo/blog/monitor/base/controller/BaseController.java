package com.echo.blog.monitor.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping("/index")
    public String HomePage() {
        return ("/index");
    }
}
