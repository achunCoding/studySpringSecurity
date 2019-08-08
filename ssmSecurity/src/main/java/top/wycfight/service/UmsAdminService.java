package top.wycfight.service;

import top.wycfight.entity.UmsAdmin;
import top.wycfight.entity.UmsPermission;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 后台管理员Service
 * @create: 2019-08-08 08:45
 * @modified By:
 **/
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员信息
     * @param username 用户名
     * @return 管理员信息
     * @author wangyanchun
     * @date 2019年8月8日08:46:38
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId 管理员ID
     * @return 管理员所有权限
     * @author wangyanchun
     * @date 2019年8月8日08:55:57
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
