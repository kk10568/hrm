package com.hrm.system.service.impl;

import com.hrm.model.system.entity.Role;
import com.hrm.system.mapper.RoleMapper;
import com.hrm.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-18 13:29
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(Role recover) {
        return roleMapper.insert(recover);
    }

    @Override
    public int delete(String id) {
        return roleMapper.delete(id);
    }

    @Override
    public int update(Role recover) {
        return roleMapper.update(recover);
    }

    @Override
    public Role findById(String id) {
        return roleMapper.findById(id);
    }

    @Override
    public List<Role> findAll(String companyId) {
        return roleMapper.findAll(companyId);
    }

    @Override
    public List<Role> findAllPage(String companyId, int minPage, int maxPage) {
        return roleMapper.findAllPage(companyId, minPage, maxPage);
    }

    @Override
    public int count(String companyId) {
        return roleMapper.count(companyId);
    }
}
