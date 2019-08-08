package top.wycfight.dao;

import org.apache.ibatis.annotations.Param;
import top.wycfight.entity.UmsPermission;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 后台用户与角色管理自定义Dao
 * @create: 2019-08-08 09:01
 * @modified By:
 **/
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     * @param adminId  管理员ID
     * @return 权限列表
     * @author wangyanchun
     * @date 2019年8月8日09:02:06
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
