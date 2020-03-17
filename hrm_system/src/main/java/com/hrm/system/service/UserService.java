package com.hrm.system.service;

import com.hrm.model.system.entity.User;

import java.util.List;

public interface UserService {

    int insert(User record);

    int deleteById(String id);

    int update(User record);

    List<User> selectAll();

    List<User> selectAllPage(int pageMin, int pageMax);

    User selectById(String id);
}
