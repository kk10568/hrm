package com.hrm.system.mapper;

import com.hrm.model.system.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-18 16:46
 **/
@Mapper
public interface PermissionMapper {

    int insert( Permission recover);

    int delete(String id);

    int update(@Param("permission")Permission recover);

    List<Permission> findAll(String type, String pid, String enVisible);

    Permission findById(String id);
}
