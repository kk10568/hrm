package com.hrm.model.system.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 17:15
 **/
public class UserRole implements Serializable {
    private static final long serialVersionUID = -8915193906003674783L;

    private String roleId;
    private String userId;

    public UserRole(String roleId, String userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
