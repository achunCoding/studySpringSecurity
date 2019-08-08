package top.wycfight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import top.wycfight.bo.AdminUserDetails;
import top.wycfight.entity.UmsAdmin;
import top.wycfight.entity.UmsPermission;
import top.wycfight.service.UmsAdminService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2019-08-08 08:42
 * @modified By:
 **/
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(s);
        if (umsAdmin != null) {
            List<UmsPermission> permissionList = umsAdminService.getPermissionList(umsAdmin.getId());
            return new AdminUserDetails(umsAdmin, permissionList);
        }
        throw new UsernameNotFoundException("用户名或者密码错误");


    }
}
