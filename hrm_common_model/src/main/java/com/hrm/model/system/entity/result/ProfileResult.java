package com.hrm.model.system.entity.result;

import com.hrm.model.system.entity.Permission;
import com.hrm.model.system.entity.Role;
import com.hrm.model.system.entity.User;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.*;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-22 13:42
 **/
public class ProfileResult implements Serializable, AuthCachePrincipal {
    private static final long serialVersionUID = 4645686409133278282L;
    private String mobile;
    private String username;
    private String company;
    private String companyId;
    private Map<String, Object> roles = new HashMap<>();

    public ProfileResult() {
    }

    public ProfileResult(User user) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();
        this.companyId = user.getCompanyId();
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        List<Role> roles = user.getRoles();
        //User和Role一对多。循环所有role
        for (Role role : roles) {
            List<Permission> permissions = role.getPermissions();
            //role和permission一对多。循环所有的permission
            for (Permission permission : permissions) {
                //每个permission中如果type=1则为permissionMenu
                //type=1则为permissionMenu
                //type=2则为permissionPoint
                //type=3则为permissionApi
                String code = permission.getCode();
                if (permission.getType() == 1) {
                    menus.add(code);
                } else if (permission.getType() == 2) {
                    points.add(code);
                } else {
                    apis.add(code);
                }
            }
        }
        this.roles.put("menus", menus);
        this.roles.put("points", points);
        this.roles.put("apis", apis);
    }

    //如果user的level为管理员则拥有所有的权限，需要查询所有的权限作为参数，参与构造方法
    //这里的permissionList是所有的权限
    public ProfileResult(User user, List<Permission> permissionList) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();
        this.companyId = user.getCompanyId();
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        for (Permission perm : permissionList) {
            String code = perm.getCode();
            if (perm.getType() == 1) {
                menus.add(code);
            } else if (perm.getType() == 2) {
                points.add(code);
            } else {
                apis.add(code);
            }
        }
        this.roles.put("menus", menus);
        this.roles.put("points", points);
        this.roles.put("apis", apis);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Map<String, Object> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Object> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "ProfileResult{" +
                "mobile='" + mobile + '\'' +
                ", username='" + username + '\'' +
                ", company='" + company + '\'' +
                ", companyId='" + companyId + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
