package com.hrm.system.shiro.Realm;

import com.hrm.common.shiro.session.realm.HrmRealm;
import com.hrm.system.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 15:56
 **/
public class UserRealm extends HrmRealm {
    @Autowired
    private UserServiceImpl userService;


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken uptoken = (UsernamePasswordToken) authenticationToken;
        String username = uptoken.getUsername();
        String password = uptoken.getPassword().toString();
        return null;
    }
}
