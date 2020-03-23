package com.hrm.system.mapper;

import com.hrm.model.system.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 19:41
 **/
@Mapper
public interface PermissionMenuMapper {
    int insert(Permission permission);

    int deleteById(String id);

    int update(Permission permission);
}
