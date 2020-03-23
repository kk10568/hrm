package com.hrm.system.service;

import com.hrm.model.system.entity.Role;
import com.hrm.model.system.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserRoleService {
    int insert(UserRole recover);

    int deleteByUserId(String userId);


}
