package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Permission;
import com.hrm.system.mapper.PermissionApiMapper;
import com.hrm.system.service.PermissionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 20:02
 **/
@Service
public class PermissionApiServiceImpl implements PermissionApiService {
    @Autowired
    private PermissionApiMapper permissionApiMapper;

    @Override
    public int insert(Permission permission) {
        return permissionApiMapper.insert(permission);
    }

    @Override
    public int deleteById(String id) {
        return permissionApiMapper.deleteById(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionApiMapper.update(permission);
    }
}
