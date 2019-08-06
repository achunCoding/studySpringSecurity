package top.wycfight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wycfight@163.com
 * @description: 商品Controller
 * @create: 2019-07-30 21:39
 * @modify By:
 **/
@Controller
@RequestMapping(value = "product")
public class ProductController {

    @RequestMapping("/add")
    public String add() {
        return "product/add";
    }
    @RequestMapping("/delete")
    public String delete() {
        return "product/delete";
    }

    @RequestMapping("/update")
    public String update() {
        return "product/update";
    }
    @RequestMapping("/list")
    public String list() {
        return "product/list";
    }

}
