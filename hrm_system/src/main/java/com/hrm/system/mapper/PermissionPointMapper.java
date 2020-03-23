package com.hrm.system.mapper;

import com.hrm.model.system.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionPointMapper {
    int insert(Permission permission);

    int deleteById(String id);

    int update(Permission permission);
}
