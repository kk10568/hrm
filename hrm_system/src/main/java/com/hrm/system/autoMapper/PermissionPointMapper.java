package com.hrm.system.autoMapper;


import com.hrm.model.system.entity.PermissionPoint;

public interface PermissionPointMapper {
    int deleteByPrimaryKey(String id);

    int insert(PermissionPoint record);

    int insertSelective(PermissionPoint record);

    PermissionPoint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PermissionPoint record);

    int updateByPrimaryKey(PermissionPoint record);
}