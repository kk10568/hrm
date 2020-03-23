package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Role;
import com.hrm.model.system.entity.UserRole;
import com.hrm.system.mapper.UserRoleMapper;
import com.hrm.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-23 17:19
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int insert(UserRole recover) {
        return userRoleMapper.insert(recover);
    }

    @Override
    public int deleteByUserId(String userId) {
        return userRoleMapper.deleteByUserId(userId);
    }

}
