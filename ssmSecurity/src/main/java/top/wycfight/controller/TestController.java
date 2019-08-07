package top.wycfight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.entity.UmsAdmin;
import top.wycfight.mapper.UmsAdminMapper;

/**
 * @author: wycfight@163.com
 * @description: 测试Controller
 * @create: 2019-08-07 08:48
 * @modified By:
 **/
@RestController
public class TestController {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @RequestMapping(value = "/testMapper")
    public String testMapper() {
        UmsAdmin umsAdmin = umsAdminMapper.selectByPrimaryKey(1L);
        return umsAdmin.toString();
    }
}
