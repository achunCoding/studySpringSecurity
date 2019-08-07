package top.wycfight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wycfight@163.com
 * @description: 首页
 * @create: 2019-07-30 22:08
 * @modify By:
 **/
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
