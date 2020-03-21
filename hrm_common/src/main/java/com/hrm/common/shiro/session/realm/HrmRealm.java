package com.hrm.common.shiro.session.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 15:49
 **/
//企业权限Realm
public class HrmRealm extends AuthorizingRealm {
    //这里只做权限验证。认证在system中的userRealm中实现

    @Override
    public void setName(String name) {
        super.setName("HrmRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
