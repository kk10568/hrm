package com.hrm.system.service;

import com.hrm.model.system.entity.Permission;

import java.util.List;

public interface PermissionService {
    int insert(Permission recover);

    int delete(String id);

    int update(Permission recover);

    List<Permission> findAll(String type,String pid ,String enVisible);

    Permission findById(String id);

    List<Permission> findByType(int type);
}
