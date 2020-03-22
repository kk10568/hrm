package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Permission;
import com.hrm.system.mapper.PermissionMapper;
import com.hrm.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-18 16:28
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int insert(Permission recover) {
        return permissionMapper.insert(recover);
    }

    @Override
    public int delete(String id) {
        return permissionMapper.delete(id);
    }

    @Override
    public int update(Permission recover) {
        return permissionMapper.update(recover);
    }

    @Override
    public List<Permission> findAll(String type,String pid ,String enVisible) {
        return permissionMapper.findAll(type, pid, enVisible);
    }

    @Override
    public Permission findById(String id) {
        return permissionMapper.findById(id);
    }

    @Override
    public List<Permission> findByType(int type) {
        return null;
    }
}
