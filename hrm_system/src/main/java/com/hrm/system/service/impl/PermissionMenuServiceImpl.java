package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Permission;
import com.hrm.system.mapper.PermissionMenuMapper;
import com.hrm.system.service.PermissionMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 20:05
 **/
@Service
public class PermissionMenuServiceImpl implements PermissionMenuService {
    @Autowired
    private PermissionMenuMapper permissionMenuMapper;
    @Override
    public int insert(Permission permission) {
        return permissionMenuMapper.insert(permission);
    }

    @Override
    public int deleteById(String id) {
        return permissionMenuMapper.deleteById(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionMenuMapper.update(permission);
    }
}
