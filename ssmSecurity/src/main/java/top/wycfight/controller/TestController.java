package top.wycfight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.entity.UmsAdmin;
import top.wycfight.entity.UmsPermission;
import top.wycfight.service.UmsAdminService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 测试Controller
 * @create: 2019-08-07 08:48
 * @modified By:
 **/
@RestController
public class TestController {


    @Autowired
    private UmsAdminService umsAdminService;

    /**
     * 测试Mapper是否能使用
     * @return
     */
    @RequestMapping(value = "/testMapper")
    public String testMapper() {
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername("test");
        return umsAdmin.toString();
    }

    /**
     * 测试权限是否能查询到
     * @return
     */
    @RequestMapping(value = "/testPermission")
    public String testPermission() {
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(3L);
        return permissionList.toString();
    }
}
