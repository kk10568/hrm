package com.hrm.system.autoMapper;

import com.hrm.model.system.entity.PermissionApi;

public interface PermissionApiMapper {
    int deleteByPrimaryKey(String id);

    int insert(PermissionApi record);

    int insertSelective(PermissionApi record);

    PermissionApi selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PermissionApi record);

    int updateByPrimaryKey(PermissionApi record);
}