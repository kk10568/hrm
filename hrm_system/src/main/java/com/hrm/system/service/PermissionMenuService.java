package com.hrm.system.service;

import com.hrm.model.system.entity.Permission;

public interface PermissionMenuService {
    int insert(Permission permission);

    int deleteById(String id);

    int update(Permission permission);
}
