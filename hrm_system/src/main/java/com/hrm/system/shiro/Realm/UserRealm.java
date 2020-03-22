package com.hrm.system.shiro.Realm;

import com.hrm.common.shiro.session.realm.HrmRealm;
import com.hrm.model.system.entity.Permission;
import com.hrm.model.system.entity.User;
import com.hrm.model.system.entity.result.ProfileResult;
import com.hrm.system.service.impl.PermissionServiceImpl;
import com.hrm.system.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 15:56
 **/
public class UserRealm extends HrmRealm {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PermissionServiceImpl permissionService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken uptoken = (UsernamePasswordToken) authenticationToken;
        String mobile = uptoken.getUsername();
        String password = new String(uptoken.getPassword());
        User user = userService.selectByMobile(mobile);
        if (user != null && user.getPassword().equals(password)) {
            //4.构造安全数据并返回（安全数据：用户基本数据，权限信息 profileResult）
            ProfileResult result = null;
            if ("user".equals(user.getLevel())) {
                result = new ProfileResult(user);
            } else {
                String enVisible = null;
                //如果level为coAdmin则只能显示enVisible为1的角色
                if ("coAdmin".equals(user.getLevel())) {
                    enVisible = "1";
                }
                List<Permission> list = permissionService.findAll(null, null, enVisible);
                result = new ProfileResult(user, list);
            }
            //构造方法：安全数据，密码，realm域名
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(result, user.getPassword(), this.getName());
            System.out.println("验证成功");
            return info;
        }
        //如果匹配不上或查询不到这个用户。则返回null抛出认证异常
        System.out.println("验证失败");
        return null;
    }
}
