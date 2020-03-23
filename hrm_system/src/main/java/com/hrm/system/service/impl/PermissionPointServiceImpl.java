package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Permission;
import com.hrm.system.mapper.PermissionMapper;
import com.hrm.system.mapper.PermissionPointMapper;
import com.hrm.system.service.PermissionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 20:04
 **/
@Service
public class PermissionPointServiceImpl implements PermissionPointMapper {
    @Autowired
    private PermissionPointMapper permissionPointMapper;
    @Override
    public int insert(Permission permission) {
        return permissionPointMapper.insert(permission);
    }

    @Override
    public int deleteById(String id) {
        return permissionPointMapper.deleteById(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionPointMapper.update(permission);
    }
}
