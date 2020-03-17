package com.hrm.system.autoMapper;


import com.hrm.model.system.entity.PermissionMenu;

public interface PermissionMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(PermissionMenu record);

    int insertSelective(PermissionMenu record);

    PermissionMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PermissionMenu record);

    int updateByPrimaryKey(PermissionMenu record);
}