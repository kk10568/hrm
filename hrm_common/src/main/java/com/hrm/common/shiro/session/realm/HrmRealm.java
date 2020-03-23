package com.hrm.common.shiro.session.realm;

import com.hrm.model.system.entity.result.ProfileResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

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
    //授权方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取安全数据
        ProfileResult result = (ProfileResult) principalCollection.getPrimaryPrincipal();
        //2.获取权限信息
        Set<String> apisPerms = (Set<String>)result.getRoles().get("apis");
        //3.构造权限数据，返回值
        System.out.println("进项授权"+apisPerms);
        SimpleAuthorizationInfo info = new  SimpleAuthorizationInfo();
        info.setStringPermissions(apisPerms);
        return info;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
