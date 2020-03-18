package com.hrm.system.service;

import com.hrm.model.system.entity.Role;

import java.util.List;

public interface RoleService {
    int insert(Role recover);

    int delete(String id);

    int update(Role recover);

    Role findById(String id);

    List<Role> findAll(String companyId);

    List<Role> findAllPage(String companyId, int minPage, int maxPage);

    int count(String companyId);
}
