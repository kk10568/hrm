package com.hrm.system.service;

import com.hrm.model.system.entity.User;

import java.util.List;

public interface UserService {

    int insert(User record);

    int deleteById(String id);

    int update(User record);

    List<User> selectAll(String companyId);

    List<User> selectAllPage(String companyId,int pageMin, int pageMax);

    User selectById(String id);

    int count();
}
