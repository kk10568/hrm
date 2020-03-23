package com.hrm.system.mapper;

import com.hrm.model.system.entity.Role;
import com.hrm.model.system.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 17:13
 **/
@Mapper
public interface UserRoleMapper {
    int insert(UserRole recover);

    int deleteByUserId(String userId);

}
